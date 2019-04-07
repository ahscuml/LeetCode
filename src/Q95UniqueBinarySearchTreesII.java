import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2019/4/5
 * @time 15:46
 */
public class Q95UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        //TODO 测试用例
    }

    /**
     * 优化后的方法，也就是利用动态规划的特性，用空间换时间，将之前的内容存储起来
     * 同时应用了一个小trick，左子树可以直接从之前的子树移动过来。
     */
    public static List<TreeNode> generateTreesII(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<>();
        if (n == 0) {
            return res[0];
        }
        // 赋值空
        res[0].add(null);
        // 1-i产生的结果
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<TreeNode>();
            // j是左子树的元素个数
            for (int j = 0; j < i; j++) {
                for (TreeNode left : res[j]) {
                    for (TreeNode right : res[i - j - 1]) {
                        // 根节点的值
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
    }

    /**
     * 节省空间，将从1开始的子树通过加上offset拷贝过来。因为右子树是从 offset + 1 开始的
     */
    public static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    /**
     * 暴力解法：通过辅助函数来完成(依然打败了63%)
     * 缺点是没有利用之前存储的内容来进行计算
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        return generateHelper(1, n);
    }

    /**
     * 辅助函数的主要思路是分别得出左右子树的可能性，然后将这些子树拼接到一起，加入结果集
     */
    public List<TreeNode> generateHelper(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generateHelper(s, i - 1);
            List<TreeNode> right = generateHelper(i + 1, e);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
