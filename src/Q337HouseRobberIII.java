import java.util.HashMap;

/**
 * 树形打劫
 *
 * @author ahscuml
 * @date 2018/11/19
 * @time 23:05
 */
public class Q337HouseRobberIII {
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

        System.out.println(robRec(treeNode1));
        System.out.println(robRecWithMemo(treeNode1));
        System.out.println(robRecOpt(treeNode1));
    }

    /**
     * 简单的递归的想法，当前节点的最大值是Math.max(两个直系子节点最大值，四个子子节点的最大值)
     * 递归的方法，找到递归的内容
     */
    public static int robRec(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }

        int val = 0;
        if (root.left != null) {
            val += robRec(root.left.left) + robRec(root.left.right);
        }

        if (root.right != null) {
            val += robRec(root.right.left) + robRec(root.right.right);
        }
        return Math.max(robRec(root.left) + robRec(root.right), val + root.val);
    }

    /**
     * 递归方法的优化，空间换时间的想法,将之前计算过的结果存储到HashMap中
     */
    private static int robRecWithMemo(TreeNode root) {
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        return robRecWithMemoHelper(root, hashMap);
    }

    private static int robRecWithMemoHelper(TreeNode root, HashMap<TreeNode, Integer> hashMap) {
        if (root == null) {
            return 0;
        }

        if (hashMap.containsKey(root)) {
            return hashMap.get(root);
        }

        int val = 0;
        if (root.left != null) {
            val += robRecWithMemoHelper(root.left.left, hashMap) + robRecWithMemoHelper(root.left.right, hashMap);
        }
        if (root.right != null) {
            val += robRecWithMemoHelper(root.right.left, hashMap) + robRecWithMemoHelper(root.right.right, hashMap);
        }

        val = Math.max(root.val + val, robRecWithMemoHelper(root.left, hashMap) + robRecWithMemoHelper(root.right,
                hashMap));
        hashMap.put(root, val);
        return val;
    }

    /**
     * 上面算法的优化，同样是空间换时间，但是空间不需要那么多
     * 使用一个数组存储需要用到的内容，一个是不使用当前节点的最大值，一个是使用当前节点的最大值
     */
    private static int robRecOpt(TreeNode root) {
        return Math.max(robRecOptHelper(root)[0], robRecOptHelper(root)[1]);
    }

    private static int[] robRecOptHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = robRecOptHelper(root.left);
        int[] right = robRecOptHelper(root.right);
        int[] res = new int[2];

        // 很巧妙的想法
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    /**
     * 树的定义
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
