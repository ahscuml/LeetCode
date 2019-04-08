/**
 * @author ahscuml
 * @date 2019/4/9
 * @time 0:54
 */
public class Q718MaximumLengthofRepeatedSubarray {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }

    /**
     * 动态规划
     * 找到规律，也就是递推关系式很好处理
     */
    public static int findLength(int[] A, int[] B) {
        int res = 0;
        // DP问题
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
