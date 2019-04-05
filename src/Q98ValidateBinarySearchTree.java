import util.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树是不是合理的
 *
 * @author ahscuml
 * @date 2018/12/28
 * @time 16:34
 */
public class Q98ValidateBinarySearchTree {
    //TODO 测试函数书写;
    public static void main(String[] args) {

    }

    /**
     * key：二叉搜索树的中序遍历是有序数列
     * 递归的方法
     * 比较当前节点的值大于最小的值与小于最大的值， 重点在于最小的值与最大的值的定义，左右子树的定义过不一样
     */
    public boolean isValidBSTRec(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    /**
     * 循环的解法
     * 循环的解法相当于一个中序遍历的循环方法，只不过当前元素要比前一个元素大
     */
    public boolean isValidBSTIte(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
