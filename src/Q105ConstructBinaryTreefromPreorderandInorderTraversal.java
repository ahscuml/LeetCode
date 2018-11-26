import java.util.HashMap;
import java.util.Map;

/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 21:02
 */
public class Q105ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {

    }

    /**
     *  思路很简单
     *  前序遍历第一个值是根节点 ，中序中找到根节点，前面的就是左子树，后面的就是右子树
     *  这样子就能构建出一个树了
     * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 利用HashMap存储可以快速通过值找到下标
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        // 在in中通过pre的值找到下标 
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
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
