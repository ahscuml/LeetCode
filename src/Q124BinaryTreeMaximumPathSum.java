import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 12:09
 */
public class Q124BinaryTreeMaximumPathSum {
    /**
     * 还是利用了递归的思想，以当前节点为中心，找到左右两边最大的子树，然后加起来
     */
    public static int max = Integer.MIN_VALUE;

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(maxPathSum(t1));
    }

    /**
     * 返回这个最大值
     * */
    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    /**
     * 返回以当前节点为中心的最大的左节点或者右节点
     */
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        // 最大值的判断
        max = Math.max(max, left + right + node.val);
        // 这是要返回的内容，最大的左或右，别忘了加上val
        return Math.max(left, right) + node.val;
    }
}
