/**
 * @author ahscuml
 * @date 2019/1/25
 * @time 14:45
 */
public class Q714BestTimetoBuyandSellStockwithTransactionFee {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    /**
     * 动态规划
     * 状态机
     */
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
        }
        return sell[n - 1];
    }
}
