import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 19:01
 */
public class Q572SubtreeofAnotherTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(2);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode8;

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(2);

        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;

        System.out.println(isSubtree(treeNode1, treeNode4));
    }

    /**
     * 首先对S进行遍历，找到和t值得元素，然后对这两个树进行判断
     * 另外一个思路是通过构建String的方法来进行判断。
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        // 首先要在S中找到和T根节点值相同的点，然后，从这个点两个遍历

        // 对s的遍历 层序
        Queue<TreeNode> queue = new LinkedList();
        TreeNode cur;
        queue.offer(s);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.val == t.val) {
                if (check(cur, t)) {
                    return true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }

    private static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        // 同时遍历两个树，判断是否相同
        if (s.val == t.val) {
            // 注意一定要同时判断，因为左右两个子树应该均为空
            return check(s.left, t.left) && check(s.right, t.right);
        }
        return false;
    }
}
