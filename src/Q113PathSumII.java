import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/20
 * @time 15:23
 */

public class Q113PathSumII {
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

        System.out.println(pathSumRec(treeNode1, 7));
        System.out.println(pathSumIte(treeNode1, 7));
    }

    /**
     * 利用辅助函数，递归，存贮，重点是在什么时候删除已经遍历过的不合适的节点
     * 这个是递归的方法
     */
    public static List<List<Integer>> pathSumRec(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSumHelper(root, sum, cur, res);
        return res;
    }

    public static void pathSumHelper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        // 结果中添加当前节点
        cur.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList(cur));
        } else {
            pathSumHelper(root.left, sum, cur, res);
            pathSumHelper(root.right, sum, cur, res);
        }
        // 左右节点遍历过后移除当前节点
        cur.remove(cur.size() - 1);
    }

    /**
     * 循环的方法
     * 将人做事情的思路用代码写出来了
     */
    public static List<List<Integer>> pathSumIte(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curSum = 0;
        while (cur != null || !stack.isEmpty()) {
            // 一路向左遍历,直到叶子节点
            while (cur != null) {
                stack.push(cur);
                path.add(cur.val);
                curSum += cur.val;
                cur = cur.left;
            }
            // 一路向左到头了，回溯 cur现在是子节点的父节点
            cur = stack.peek();
            // 如果有右边的节点，继续上面的过程直到叶子节点
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                // continue很灵性
                continue;
            }
            // 满足条件，添加到结果中
            if (cur.left == null && cur.right == null && curSum == sum) {
                res.add(new ArrayList<>(path));
            }
            pre = cur;
            stack.pop();
            path.remove(path.size() - 1);
            curSum -= cur.val;
            cur = null;
        }
        return res;
    }
}
