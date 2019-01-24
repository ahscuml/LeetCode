/**
 * @author ahscuml
 * @date 2019/1/24
 * @time 10:20
 */
public class Q123BestTimetoBuyandSellStockIII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitII(prices));
    }

    /**
     * 状态机的方法，一种适用于所有股票问题的方法
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/149383/Easy-DP-solution-using-state
     * -machine-O(n)-time-complexity-O(1)-space-complexity
     * 重点是状态的选择，也就是状态转移的过程
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int s1 = Integer.MIN_VALUE, s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int price : prices) {
            s1 = Math.max(s1, -price);
            s2 = Math.max(s2, s1 + price);
            s3 = Math.max(s3, s2 - price);
            s4 = Math.max(s4, s3 + price);
        }
        return Math.max(s4, 0);
    }

    /**
     * DP方法 复杂一点，方便理解的方法
     * 与188 任意K次交易进行一起理解,这种方法拥有最少的空间复杂度
     */
    public static int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] f = new int[3];
        int[] g = new int[3];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            int temp = f[0];
            for (int j = 1; j <= 2; j++) {
                g[j] = Math.max(g[j], temp) + diff;
                temp = f[j];
                f[j] = Math.max(f[j], g[j]);
            }
        }
        return f[2];
    }
}
