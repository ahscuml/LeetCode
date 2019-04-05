import util.TreeNode;

/**
 * TODO 循环的方法
 *
 * @author ahscuml
 * @date 2018/11/26
 * @time 15:09
 */
public class Q617MergeTwoBinaryTrees {
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

        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(5);

        treeNode6.left = treeNode7;
        treeNode7.right = treeNode8;
        treeNode8.left = treeNode9;
        treeNode9.right = treeNode10;

        inOrderRec(mergeTrees(treeNode1, treeNode6));
    }

    /**
     * 主要是遍历两个树，针对一个树为空另一个树不为空的情况要做好处理
     * 还要考虑好如果根节点就是空的处理情况
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }

    /**
     * 中序遍历， 递归 打印这个树
     */
    private static void inOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.val);
        inOrderRec(root.right);
    }

    /**
     * 自己写的递归方法，时间复杂度O(n)
     */
    public TreeNode mergeTreesII(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
