import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转一个二叉树
 *
 * @author ahscuml
 * @date 2018/11/14
 * @time 20:17
 */
public class Q226InvertBinaryTree {
    /**
     * 测试函数
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
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

        // 反转两次相当于没有反转
        invertTreeRec(treeNode1);
        invertTreeIte(treeNode1);

        // 层序遍历这个树
        TreeNode cur;
        // LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode1);
        // 每次都是当前节点出队，然后存入当前节点的左右子节点
        while (queue.size() != 0) {
            cur = queue.poll();
            System.out.print(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 新的二叉树与原来的二叉树是对称的
     */
    public static TreeNode invertTreeRec(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invertTreeRec(root.left);
            invertTreeRec(root.right);
        }
        return root;
    }

    /**
     * 利用循环的方法
     * 重要的还是利用层序遍历的方法对树进行遍历，然后交换节点
     */
    private static TreeNode invertTreeIte(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                // 进行交换
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
