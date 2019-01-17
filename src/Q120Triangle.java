import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ahscuml
 * @date 2019/1/17
 * @time 11:08
 */
public class Q120Triangle {
    /**
     * 主函数
     */
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(triangle);

        System.out.println("triangle是: " + triangle);
        System.out.println("最短路径是：" + minimumTotal(triangle));
    }

    /**
     * 动态规划，空间换时间的想法
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        // 先从最后一层开始遍历
        for (int i = triangle.size() - 1; i >= 0; i--) {
            // 再遍历每一层的元素
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 利用数组存储当到当前元素的最小距离
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
