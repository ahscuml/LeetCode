import util.TreeNode;

/**
 * 二叉搜索树的公共祖先
 *
 * @author ahscuml
 * @date 2019/4/8
 * @time 20:19
 */
public class Q235LowestCommonAncestorofaBinarySearchTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // TODO
    }

    /**
     * 利用BST的特点
     * 利用树递归的性质
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 利用循环的方法
     */
    public TreeNode lowestCommonAncestorIte(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root == null || (root.val - p.val) * (root.val - q.val) <= 0) return root;
            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}
