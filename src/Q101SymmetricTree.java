import java.util.Stack;

/**
 * 判断一棵树是否是对称的
 *
 * @author ahscuml
 * @date 2018/11/14
 * @time 20:03
 */

public class Q101SymmetricTree {
    /**
     * 测试函数
     * 1
     * /   \
     * 2      2
     * / \    / \
     * 3  4   4   3
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(isSymmetric(treeNode1));
        System.out.println(isSymmetricIte(treeNode1));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root, root);
    }

    /**
     * 递归的方法
     * 查看两个节点的左右子节点是否相同
     */
    private static boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null) {
            return treeNode2 == null;
        }
        if (treeNode2 == null) {
            return false;
        }
        if (treeNode1.val == treeNode2.val) {
            return isSymmetric(treeNode1.left, treeNode2.right) && isSymmetric(treeNode1.right, treeNode2.left);
        }
        return false;
    }

    /**
     * 非递归方法，避免栈溢出
     * 主要利用的还是Stack
     */
    private static boolean isSymmetricIte(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;

        // 先进行一次处理，放入左右子节点，方便后面循环判断
        if (root.left != null) {
            if (root.right == null) return false;
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!stack.isEmpty()) {
            // 因为对称，存入都是一对一对的
            if (stack.size() % 2 != 0) {
                return false;
            }
            right = stack.pop();
            left = stack.pop();
            //
            if (left.val != right.val) {
                return false;
            }

            // 一个节点有两个子树，对这个节点的两个子树也进行判断
            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }

        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
