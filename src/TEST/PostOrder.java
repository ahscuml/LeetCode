package TEST;

import java.util.Stack;

/**
 * 后序遍历 递归与迭代
 *
 * @author ahscuml
 * @date 2018/11/17
 * @time 14:23
 */
public class PostOrder {
    /**
     * 测试函数
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
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

        postOrderRec(treeNode1);
        System.out.println("");
        postOrderIte(treeNode1);
    }

    /**
     * 后序遍历，递归
     */
    private static void postOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.val);
    }

    /**
     * 后序遍历，迭代
     * 后序遍历的方法与前序遍历与中序遍历的方法不太相同
     */
    private static void postOrderIte(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 新增加一个栈,利用栈先进后出的原则，先放入根节点，然后放入右节点，最后放入左节点
        Stack<TreeNode> output = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                output.push(cur);
                stack.push(cur);
                // 先进后出，所以先是右边
                cur = cur.right;
            } else {
                // output还没有出栈，stack只是为了帮助找到左子树
                cur = stack.pop();
                cur = cur.left;
            }
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().val);
        }
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
