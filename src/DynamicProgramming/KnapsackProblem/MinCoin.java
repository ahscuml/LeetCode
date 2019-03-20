package DynamicProgramming.KnapsackProblem;

/**
 * @author ahscuml
 * @date 19-3-20
 * @time 下午4:33
 */
public class MinCoin {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 11;
        System.out.println(minCoin1(coins, target));
    }

    /**
     * 首先要找到递推的关系式
     * dp[j]就是凑成j最少有多少种方法
     * */
    public static int minCoin1(int[] num, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            int min = -1;
            for (int coin : num) {
                if (i >= coin) {
                    int temp = dp[i - coin];
                    if (temp != -1) {
                        min = min == -1 ? temp + 1 : (min > temp + 1 ? temp + 1 : min);
                    }
                }
            }
            dp[i] = min;
        }
        return dp[target];
    }
}
