import util.TreeNode;

import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/20
 * @time 14:29
 */
public class Q112PathSum {
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
        System.out.println(hasPathSumRec(treeNode1, 7));
        System.out.println(hasPathSumIte(treeNode1, 7));
    }

    /**
     * 递归的方法，代码很简单
     */
    public static boolean hasPathSumRec(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSumRec(root.left, sum) || hasPathSumRec(root.right, sum);
    }

    /**
     * 采用循环的方法，可以避免堆栈的溢出，但是代码量很大，而且需要一个栈存储当前节点的和
     */
    public static boolean hasPathSumIte(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> SumForNode = new Stack<>();
        int curSum = 0;
        stack.push(root);
        SumForNode.push(0);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            curSum = SumForNode.pop();
            curSum += cur.val;
            if (cur.left == null && cur.right == null && curSum == sum) {
                return true;
            }
            if (cur.left != null) {
                stack.push(cur.left);
                SumForNode.push(curSum);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                SumForNode.push(curSum);
            }
        }
        return false;
    }
}
