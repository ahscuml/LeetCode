import util.TreeNode;

import java.util.*;

/**
 * @author ahscuml
 * @date 2018/11/21
 * @time 10:44
 */

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
        // 不一样的地方，利用ArrayList 的特点，从头添加的时候会把后面的往后移动
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    /**
     * 使用两个栈来实现，因为栈弹出的过程就是翻转的过程
     */
    private static List<List<Integer>> Helper(TreeNode root) {
        TreeNode cur;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while (!queue.isEmpty() || !stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                cur = queue.pop();
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
                if (cur.right != null) {
                    queue.push(cur.right);
                }
                if (cur.left != null) {
                    queue.push(cur.left);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
    }

    /**
     * 利用Collection.reverse函数来实现
     */
    public static List<List<Integer>> zigzagLevelOrderIte(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> curList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode cur = null;
        boolean iszigzag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while (size != 0) {
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            if (iszigzag) {
                Collections.reverse(list);
            }
            res.add(list);
            iszigzag = !iszigzag;
        }
        return res;
    }
}
