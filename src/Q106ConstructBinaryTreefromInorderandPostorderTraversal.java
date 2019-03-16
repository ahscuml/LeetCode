import util.TreeNode;

/**
 * @author ahscuml
 * @date 2019/3/15
 * @time 19:46
 */
public class Q106ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inS, int inE, int[] postorder, int pS, int pE) {
        if (inS > inE || pS > pE) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pE]);
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == root.val) {
                root.right = buildTree(inorder, i + 1, inE, postorder, pS + i - inS, pE - 1);
                root.left = buildTree(inorder, inS,i - 1, postorder, pS, pS + i - inS - 1);
            }
        }

        return root;
    }
}
