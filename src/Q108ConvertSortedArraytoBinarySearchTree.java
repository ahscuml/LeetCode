import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/1/4
 * @time 10:49
 */
public class Q108ConvertSortedArraytoBinarySearchTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 利用递归的方法来说实现
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 节点个数可能是奇数或者偶数，需要进行判断
        int n = nums.length;
        return helper(nums, 0, n - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
