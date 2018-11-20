import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/11/20
 * @time 15:23
 */
// TODO: 2018/11/20 还有循环的方法也可以试试 

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
        System.out.println(pathSum(treeNode1, 7));
    }

    /**
     * 利用辅助函数，递归，存贮，重点是在什么时候删除已经遍历过的不合适的节点
     * 这个是递归的方法
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
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
