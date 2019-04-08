/**
 * @author ahscuml
 * @date 2019/4/9
 * @time 0:27
 */
public class Q343IntegerBreak {
    public static void main(String[] args) {
        integerBreak(10);
    }

    /**
     * 需要特殊考虑2和3
     * */
    public static int integerBreak(int n) {
        // 这个一看就是动态规划的问题
        // 行就是数字n,列就是最大的乘积
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i], dp[j] * dp[i - j]), i);
            }
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }
}
