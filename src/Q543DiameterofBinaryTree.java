/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 19:52
 */

// TODO: 2018/11/26 对于递归的理解，这个问题深刻
public class Q543DiameterofBinaryTree {
    static int max = 0;

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(diameterOfBinaryTree(treeNode1));
    }

    /**
     * 我的简单的想法是遍历这个树，然后计算每一个节点的左子树长度加上右子树长度
     * 计算长度的方法就是计算树的深度的方法
     * <p>
     * 但是这样子的时间复杂度会比较长因为我做了很多无效的循环
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
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
