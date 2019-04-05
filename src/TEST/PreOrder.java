package TEST;

import util.TreeNode;

import java.util.Stack;

/**
 * 前序遍历的递归和迭代两种实现   前序遍历同样是深度优先遍历
 * 前序遍历首先访问根节点，其次是左孩子，最后是右孩子
 *
 * @author ahscuml
 * @date 2018/11/17
 * @time 11:00
 */
public class PreOrder {
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
        preorderRec(treeNode1);

        System.out.println("");

        preorderIte(treeNode1);
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
     * 前序遍历迭代方法
     */
    public static void preorderIte(TreeNode root) {
        if (root != null) {
            // 用于存储遍历过的结点
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            // 当前节点与栈都不为空
            while (cur != null || !stack.isEmpty()) {
                // 如果当前节点不为空，输出值，压入栈，移动到左子树
                if (cur != null) {
                    // 前序遍历根节点首先输出，所以输出在最前
                    System.out.print(cur.val);
                    // 将cur入栈是为了后面遍历右子树
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // 如果当前元素为空，回退到父节点，再遍历右子树，然后父节点就可以出栈了，因为他的左右子树都遍历完成了
                    cur = stack.pop();
                    cur = cur.right;
                }
            }
        }
    }
}
