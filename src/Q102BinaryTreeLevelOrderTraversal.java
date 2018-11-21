import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序打印二叉树
 *
 * @author ahscuml
 * @date 2018/11/21
 * @time 11:04
 */
public class Q102BinaryTreeLevelOrderTraversal {
    /**
     * 测试函数
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

        System.out.println(levelOrderRec(treeNode1));
        System.out.println(levelOrderIte(treeNode1));
    }

    /**
     * 采用层次遍历，两个变量用于记录当前节点和下一节点的数量
     */
    public static ArrayList<ArrayList<Integer>> levelOrderIte(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> curRes = new ArrayList();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode cur;
        // 当前层的元素数量
        int A = 1;
        // 下一层的元素数量
        int next = 0;
        while (!queue.isEmpty()) {

            cur = queue.poll();
            // 当前行减1；
            A--;
            curRes.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                next++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                next++;
            }
            if (A == 0) {
                res.add(curRes);
                curRes = new ArrayList();
                A = next;
                next = 0;
            }
        }
        return res;
    }

    /**
     * 递归的方法
     */
    public static ArrayList<ArrayList<Integer>> levelOrderRec(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    /**
     * 利用depth这个变量区分层次，方便打印
     */
    private static void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        // 这一步是重点
        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }
        // 获取之前添加的ArrayList然后添加数据；
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
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
