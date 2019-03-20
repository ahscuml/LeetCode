/**
 * @author ahscuml
 * @date 2019/3/20
 * @time 17:58
 */
public class Q322CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
        int[] coins2 = {2, 5, 10, 1};
        int amount2 = 27;
        System.out.println(coinChange(coins2, amount2));
    }

    /**
     * 自己写的方法
     * 带最字的都是动态规划的问题，所以可以从动态规划的角度考虑
     * 首先动态规划是划分成子问题，首先找出子问题
     * dp[i][j] 用 coins[0...j]的硬币，完成价格J的最少个数
     */
    public static int coinChange(int[] coins, int target) {
        if (coins == null || coins.length < 1 || target < 1) {
            return 0;
        }

        int[][] dp = new int[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < target + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                // 还要处理j - coins[i] < 0的问题
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 还要处理Integer.MAX_VALUE的问题
                    dp[i][j] = dp[i][j - coins[i]] == Integer.MAX_VALUE
                            ? dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[coins.length - 1][target] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][target];
    }

    /**
     * 循环的方式
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    /**
     * 递归的方法，自上而下
     *
     * @param coins coins we have
     * @param rem   remainint to change
     * @param count the number of coins
     */
    private int helper(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        // already computed, so reuse
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    /**
     * 循环的方法，就是我的方法的改版，不过用了空间压缩的方法，只用一个一维数组就搞定了
     * 当前金额sum的最小值是金额为sum - coin的最小值加1
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        // 当前amount所需的最少的coin次数，长度是amount + 1
        int[] dp = new int[amount + 1];
        // 当前金额
        int sum = 0;

        while (++sum <= amount) {
            // 最少的次数，对于一个数值，遍历完一遍coins才知道min
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}
