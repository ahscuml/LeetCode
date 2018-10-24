/**
 * @author ahscuml
 * @date 2018/10/24
 * @time 22:51
 */
public class Q63UniquePathsII {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(matrix));
    }

    /**
     * 与62题类似，只不过这次加上了阻挡的条件
     * 同样采用动态规划的方法，在循环中加入了判断是否有效的条件
     * 值得注意的是在边界条件地方如果出现阻断，则以后都达到不了
     * */
    public static int uniquePathsWithObstacles(int[][] matrix) {
        int[] aux = new int[matrix[0].length];
        aux[0] = 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // 增加了一处判断
                if(matrix[i][j] == 1) {
                    aux[j] = 0;
                }  else if(j > 0) {
                    aux[j] = aux[j - 1] + aux[j];
                }

            }
        }
        return aux[matrix[0].length - 1];
    }
}
