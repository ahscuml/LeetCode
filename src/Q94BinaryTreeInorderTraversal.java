import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/13
 * @time 22:42
 */
public class Q94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);

        A.right = B;
        B.left = C;
        for (int i : inorderTraversal1(A)) {
            System.out.print(i);
        }
        System.out.println("");

        for (int j : inorderTraversal2(A)) {
            System.out.print(j);
        }
    }

    /**
     * 方法一，利用递归，先遍历左孩子，然后添加根节点，然后遍历右孩子
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private static void helper(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 方法二：利用stack存储根的值，然后进行后退
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> helper = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !helper.isEmpty()) {
            while (cur != null) {
                helper.push(cur);
                cur = cur.left;
            }
            cur = helper.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
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
