/**
 * @author ahscuml
 * @date 2019/1/17
 * @time 15:50
 */
public class Q221MaximalSquare {
    /**
     * 主函数
     */
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1',
                '0', '0', '1', '0'}};
        System.out.println("最大的面积是" +
                "；" + maximalSquare(matrix));
        System.out.println("最大的面积是" + maximalSquareII(matrix));
    }

    /**
     * 利用动态规划的方法
     * 重点是要找到equation ：we define the state as the maximal size of the square that can be achieved at point (i, j)
     * 我自己的想法，写起来很啰嗦
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 创建新的辅助数组，用于存储当前的元素所能组成的最大的矩形边长
        int dp[][] = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边界的直接赋原值
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    // 如果当前的是1
                    if (matrix[i][j] == '1') {
                        // 如果左上角还是1
                        if (matrix[i - 1][j - 1] == '1') {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                        } else {
                            // 左上角不是1，那当前就是1
                            dp[i][j] = 1;
                        }
                        // 如果当前是0，那就是0了
                    } else {
                        dp[i][j] = 0;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    /**
     * 更加快速简便的方法，思路都是相同的，通过增加长和宽来完成减小复杂度
     */
    public static int maximalSquareII(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        // dp[i][j]对应着matrix[i - 1][j - 1]
        // 新的数组默认值是0
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
