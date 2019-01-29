/**
 * @author ahscuml
 * @date 2019/1/29
 * @time 20:21
 */
public class Q74Searcha2DMatrix {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrixII(matrix, target));
    }

    /**
     * 由于matrix是排好序的，可以按照剑指offer的第四题的想法来做，先确定在那一列，然后再确定在哪一行，
     * 从列最大，行最小的开始遍历
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

    /**
     * 第二种方法，这道题和剑指offer的题还不是完全的一样，因为这道题的二维数组是完全排好序的，所以也可以在二维数组中应用
     * 二分查找。
     */
    public static boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int l = 0, r = rowMax * colMax - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int row = mid / colMax;
            int col = mid % colMax;
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
