import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一棵二叉树的最大深度
 *
 * @author ahscuml
 * @date 2018/11/14
 * @time 20:05
 */
public class Q104MaximumDepthofBinaryTree {
    private static int maxDepth;

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

        System.out.println(maxDepthRec(treeNode1));
        System.out.println(maxDepthIte(treeNode1));
    }

    public static int maxDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    /**
     * 辅助函数，使用的是递归的方法
     */
    public static int maxDepth(TreeNode root, int depth) {

        if (root != null) {
            maxDepth(root.left, depth + 1);
            maxDepth(root.right, depth + 1);
            maxDepth = Math.max(maxDepth, depth);
            return maxDepth;
        }
        return 0;
    }

    /**
     * 非递归的方法计算最大深度
     */
    private static int maxDepthIte(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        int level = 0;
        // current是已经出栈的个数，last是一层有多少个元素
        int current, last;
        while (!queue.isEmpty()) {
            current = 0;
            last = queue.size();
            while (current < last) {
                cur = queue.poll();
                current++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return level;
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
