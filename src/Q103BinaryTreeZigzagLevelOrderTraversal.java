import java.util.*;

/**
 * @author ahscuml
 * @date 2018/11/21
 * @time 10:44
 */

// TODO: 2018/11/21 翻转的方法时间复杂度可能不太好，1.利用LinkedList双向链表来进行双向遍历
public class Q103BinaryTreeZigzagLevelOrderTraversal {
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

        System.out.println(zigzagLevelOrderIte(treeNode1));
        System.out.println(zigzagLevelOrderRec(treeNode1));
        System.out.println(Helper(treeNode1));
    }

    /**
     * 通过翻转来实现，循环算法
     */
    public static List<List<Integer>> zigzagLevelOrderIte(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curRes = new ArrayList();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode cur;
        int level = 1;
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
                if (level % 2 == 0) {
                    Collections.reverse(curRes);
                }
                res.add(curRes);
                curRes = new ArrayList();
                A = next;
                next = 0;
                level++;
            }
        }
        return res;
    }


    /**
     * 递归的算法
     */
    public static List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private static void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    /**
     * 使用一个栈与一个队列来实现，因为栈弹出的过程就是翻转的过程
     */
    private static List<List<Integer>> Helper(TreeNode root) {
        TreeNode cur;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() || !stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            res.add(temp);
            temp = new ArrayList<>();
            while (!stack.isEmpty()) {
                cur = stack.pop();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
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
