package DynamicProgramming.KnapsackProblem;

/**
 * 矩阵的最小路径和(左上角走到右下角,只能向右和向下走)
 *
 * @author ahscuml
 * @date 19-3-20
 * @time 下午3:53
 */
public class MaxPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(maxPathSum1(matrix));
        System.out.println(maxPathSum1(matrix));
    }

    /**
     * 创建一个二维数组来存储内容，dp[i][j]代表到达当前节点的最小路径值
     * 时间复杂度O(M * N),空间复杂度O(M * N)
     * */
    public static int maxPathSum1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

    /**
     * 对于上面的方法的优化，时间复杂度不变，但是空间复杂度变为O(mni(M,N))
     * */
    public static int maxPathSum2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int more = Math.max(col, row);
        int less = Math.min(col, row);
        // 判断是行更多一些，还是列更多一些
        boolean rowmore = more == col;
        int[] dp = new int[less];
        dp[0] = matrix[0][0];
        for (int i = 1; i < less; i++) {
            dp[i] = dp[i - 1] + (rowmore ? matrix[0][i] : matrix[i][0]);
        }
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowmore ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowmore ? matrix[i][j] : matrix[j][i]);
            }
        }
        return dp[less - 1];
    }
}
