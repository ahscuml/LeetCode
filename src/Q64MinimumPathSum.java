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
    }

    /**
     * 依旧使用动态规划，和62,63一样的想法。
     * 可以不使用额外的存储空间，直接将内容存储到matrix中，可以试试这个想法。
     * */
    public static int minPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int[] aux = new int[n];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < n; j++) {
                if (j == 0) {
                    aux[j] = aux[j] + matrix[i][j];
                } else if(i == 0){
                    aux[j] = aux[j - 1] + matrix[i][j];
                } else {
                    aux[j] = matrix[i][j] + Math.min(aux[j - 1], aux[j]);
                }
            }
        }
        return aux[n - 1];
    }
}
