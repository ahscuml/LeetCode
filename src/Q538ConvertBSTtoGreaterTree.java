import util.TreeNode;

import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 16:24
 */
public class Q538ConvertBSTtoGreaterTree {

    private static int count = 0;

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(13);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        preorderRec(convertBSTIte(treeNode1));
        System.out.println("");
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(13);

        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;

        preorderRec(convertBSTRec(treeNode4));
    }

    /**
     * 前序遍历，递归方法
     */
    public static void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /**
     * 二叉搜索树的性质：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * <p>
     * 根据二叉搜索树的性质，可以找到这道题的规律
     * 相当于从右向左的中序遍历，然后通过将之前节点的值不断相加到一起
     */
    public static TreeNode convertBSTRec(TreeNode root) {
        if (root == null) return null;
        convertBSTRec(root.right);
        root.val += count;
        count = root.val;
        convertBSTRec(root.left);
        return root;
    }

    /**
     * 循环的方法
     */
    public static TreeNode convertBSTIte(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 首先压入右节点，先进后出，找到最大的元素
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();

            cur.val += sum;
            sum = cur.val;
            // 左节点也比父节点大，所以找到左节点，先右，后中，再左
            cur = cur.left;
        }
        return root;
    }
}
