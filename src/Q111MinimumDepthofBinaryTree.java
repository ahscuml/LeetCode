import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/3/18
 * @time 19:40
 */
public class Q111MinimumDepthofBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 重点就是要处理好只有两个节点的情况，这时候返回2
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
