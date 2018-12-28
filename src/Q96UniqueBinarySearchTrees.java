/**
 * @author ahscuml
 * @date 2018/12/14
 * @time 14:55
 */
public class Q96UniqueBinarySearchTrees {
    // TODO: 2018/12/14 测试函数

    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 空间换时间，记录之前的结果
     */
    public int numTrees(int n) {
        // 二叉搜索树要满足左小右大的条件
        // 首先元素应该是排好序的
        // 1. 定位根节点，比n大的在左，比n小的在右
        // 2. 左边i个元素，右边j个元素，i + j + 1 = n
        // 3. 递归的思路，因为字母顺序都是固定的，只不过是几个元素的问题
        // 4. 再利用空间换时间的想法来优化这个问题

        // 由于是从0开始连续的数字，所以也可以考虑使用数组来存储元素
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                num[j] += num[i - 1] * num[j - i];
            }
        }
        return num[n];
    }
}
