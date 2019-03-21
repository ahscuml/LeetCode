/**
 * @author ahscuml
 * @date 2019/3/16
 * @time 9:00
 */
public class Q97InterleavingString {

    /**
     * DP的方法
     * 首先要明白子问题是什么
     * 空间换时间，空间的意义是什么
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        // 需要存储的空间
        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];
        matrix[0][0] = true;
        // 初始化第一行
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        // 初始化第一列
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        // 利用之前的计算填充二维数组
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return matrix[s2.length()][s1.length()];
    }
}
