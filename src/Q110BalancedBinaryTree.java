import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 17:07
 */
public class Q110BalancedBinaryTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // TODO
    }

    /**
     * 自底向上的方法，计算深度，然后返回。
     * 时间复杂度O(nlogn)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        // 针对每一个深度都得符合要求
        if (Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * 自顶向下的方法
     * 时间复杂度O(n)
     */
    public boolean isBalancedII(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归调用，计算深度
        int lH = height(node.left);
        if (lH == -1) {
            return -1;
        }
        // 右边递归调用，计算深度
        int rH = height(node.right);
        if (rH == -1) {
            return -1;
        }
        // 判断当前行是否满足要求，不满足要求直接返回-1
        if (lH - rH < -1 || lH - rH > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
    }
}
