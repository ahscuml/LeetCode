/**
 * @author ahscuml
 * @date 2019/1/24
 * @time 16:57
 */
public class Q309BestTimetoBuyandSellStockwithCooldown {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitII(prices));
    }

    /**
     * 动态规划
     * 重点是找到要递推的关系式
     * 然后精简代码，不需要所有的结果都存储下来
     * 这个解法的递推关系式是：
     * i就是在第i天cooldown或者买卖
     * 1. buy[i] = max(sell[i-2]-price, buy[i-1])
     * 2. sell[i] = max(buy[i-1]+price, sell[i-1])
     * 精简的过程就是最多只需要i - 2天的数据，所以之前的可以不存储
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int buy = Integer.MIN_VALUE, preBuy = 0;
        int sell = 0, preSell = 0;
        for (int price : prices) {
            // 现在的sell，是preSell,preSell是再前一天的sell
            // 现在的buy，是preBuy
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);

            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }
        return sell;
    }

    /**
     * 状态机的方法
     * 有关状态机的划分：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP
     * -solution-(By-State-Machine-Thinking)
     */
    public static int maxProfitII(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[n - 1], s2[n - 1]);
    }
}
