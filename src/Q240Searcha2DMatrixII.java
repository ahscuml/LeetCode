/**
 * @author ahscuml
 * @date 2019/1/29
 * @time 21:17
 */
public class Q240Searcha2DMatrixII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23,
                26, 30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, 5));
    }

    /**
     * 和剑指offer的第四题一样
     * 最好的方法是行最小，列最大，这样子来寻找
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int row = 0, col = colMax - 1;
        while (row < rowMax && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
