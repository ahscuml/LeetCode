/**
 * @author ahscuml
 * @date 2018/10/24
 * @time 9:36
 */
public class Q64MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(nums));
        System.out.println(minPathSumII(nums));
    }

    /**
     * 依旧使用动态规划，和62,63一样的想法。
     * 可以不使用额外的存储空间，直接将内容存储到matrix中，可以试试这个想法。
     */
    public static int minPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int[] aux = new int[n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    aux[j] = aux[j] + matrix[i][j];
                } else if (i == 0) {
                    aux[j] = aux[j - 1] + matrix[i][j];
                } else {
                    aux[j] = matrix[i][j] + Math.min(aux[j - 1], aux[j]);
                }
            }
        }
        return aux[n - 1];
    }

    /**
     * 动态规划的方法，只不过采用的是二维的数组，最基本的想法
     * 注意创建辅助数组的时候的长度以及创建完成以后首先对00赋值
     */
    public static int minPathSumII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
