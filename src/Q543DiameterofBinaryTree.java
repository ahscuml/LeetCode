/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 19:52
 */

// TODO: 2018/11/26 对于递归的理解，这个问题深刻
public class Q543DiameterofBinaryTree {
    int max = 0;

    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 我的简单的想法是遍历这个树，然后计算每一个节点的左子树长度加上右子树长度
     * 计算长度的方法就是计算树的深度的方法
     * <p>
     * 但是这样子的时间复杂度会比较长因为我做了很多无效的循环
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);
        // 递归的精髓，每加一层就加一
        return Math.max(left, right) + 1;
    }

    /**
     * 树结构的定义
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
