/**
 * @author ahscuml
 * @date 2019/1/24
 * @time 14:51
 */
public class Q188BestTimetoBuyandSellStockIV {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
        System.out.println(maxProfitII(k, prices));
    }

    /**
     * 动态规划的方法，通俗易懂，空间复杂度比较高
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     * = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    /**
     * DP方法 和上面方法的差别就是降低了时间复杂度
     * 1. 参数解释
     * f[k][i]: max profit up to day i (included) with at most k transactions (global optimal objective)
     * g[k][i]: max profit up to day i (included) with at most k transactions AND we sell at day i
     * 2. 递推公式
     * (1). f[k][i] = max ( f[k][i-1], g[k][i] )
     * (2). g[k][i] = max_{j=0,...,i-1} (p[i] - p[j] + f[k-1][j-1])
     * 改写第2个公式  g[k][i] = max ( g[k][i-1], f[k-1][i-1]) ) + p[i] - p[i-1]  这样子就没有j什么关系了
     * 这样改写的原因是g[k][i-1]代表第i-1天进行交易，也就不是第i-1天买入，否则就是第二个，代表可能在第i天买入
     * 3.公式来源解释
     * // (1): this means if we don't sell at day i, then f[k][i] is just f[k][i-1]; otherwise f[k][i] will be the
     * max profit that we can achieve if we sell at day i
     * (不确定第i天卖还是不卖，那第i天的最大值就是卖和不卖之间的最大值，不卖的话就是前一天的值，卖的话就是辅助数组的值)
     * // (2): since we will sell at day i anyway, that means we need to buy at a certain previous day, for a
     * particular j, the best we can have is p[i] - p[j] + f[k-1][j-1].
     * (确定在第i天卖股票，那么在第i天之前肯定得买，只有买了才能卖，所以假设在第j天买了，然后中间不进行操作，在第i天卖了，
     * 那么最大价值就是j天之前的最大值加上卖股票的价值)
     * 4. 第k天的价值只与k - 1天的价值相关联，所以可以减少存储的内容，只存储k-1天的
     */
    public static int maxProfitII(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        if (k > n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] f = new int[k + 1];
        int[] g = new int[k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            int temp = f[0];
            for (int j = 1; j <= k; j++) {
                g[j] = Math.max(g[j], temp) + diff;
                temp = f[j];
                f[j] = Math.max(f[j], g[j]);
            }
        }
        return f[k];
    }
}
