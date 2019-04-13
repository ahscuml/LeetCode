import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 18:03
 */
public class Q54SpiralMatrix {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrderII(matrix));
    }

    /**
     * 重点是一个循环的终止条件
     * 和四个打印的判断条件
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 打印rowBegin行，从colBegin到colEnd
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // 打印colEnd列
            // 这里值变换了rowBegin而且后面还是比较row，所以不用判断
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // 打印 rowEnd行
            // 这里要比较row
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // 打印colBegin列
            // 这里要比较col，因为前面改过col
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    /**
     * 第二种方法，可能更加方便记忆
     */
    public static List<Integer> spiralOrderII(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }
}
