import util.TreeNode;

import java.util.Stack;

/**
 * 将二叉树变为linkedlist
 *
 * @author ahscuml
 * @date 2018/12/28
 * @time 9:40
 */
public class Q114FlattenBinaryTreetoLinkedList {
    /**
     * 和我的思路一样，但是非常简单的写法
     */
    private TreeNode prev = null;

    // TODO 增加测试用例;
    public static void main(String[] args) {

    }

    /**
     * 我的思路，虽然代码看起来多，但是想法非常简单
     */
    public void flatten(TreeNode root) {
        // 规律就是右子树接到左子树上
        // 所以要先从后往前接上
        // 接起来需要三个节点，分别是左子节点，右子节点与父节点
        // 右子节点放到左子节点上，左子节点放到父节点上
        if (root == null) {
            return;
        }
        // 这样递归调用保证是从后面往前面进行后面的操作的
        flatten(root.right);
        flatten(root.left);
        // 如果左面空，那么不用处理，直接返回
        if (root.left == null) {
            return;
        } else if (root.right == null) { // 如果左面不空，右面空，那么左面复制到右面，左面赋空
            root.right = root.left;
            root.left = null;
        } else {
            // 左右都不空，右面放左面，左面放右面，左面为空
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public void flattenEasy(TreeNode root) {
        if (root == null)
            return;
        flattenEasy(root.right);
        flattenEasy(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * 迭代方法,先存右节点，再存左节点。
     */
    public void flattenIte(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
