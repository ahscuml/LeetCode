package TEST;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的层序遍历 同样是广度优先遍历
 *
 * @author ahscuml
 * @date 2018/11/17
 * @time 16:50
 */
public class LevelOrder {
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

        levelOrderRec(treeNode1);
        System.out.println("");
        levelOrderIte(treeNode1);
    }

    /**
     * 层序遍历， 递归方法
     * 首先层序遍历需要按照层来划分，也就是深度，
     * 然后围绕深度输出
     */
    public static void levelOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        // 分层遍历
        for (int i = 1; i <= depthIte(root); i++) {
            levleOrder(root, i);
        }
    }

    /**
     * 层序遍历辅助函数，每遍历一层level减1，直到level为1，输出这一层的元素值
     */
    private static void levleOrder(TreeNode root, int level) {
        if (root == null || level < 1) {
            return;
        }
        // 这里的level不是指树的层，指还剩的层数
        if (level == 1) {
            System.out.print(root.val);
        }
        // 每向下遍历一层，层数就减1，直到层数为1，遍历的就是这一层，输出节点的值
        levleOrder(root.left, level - 1);
        levleOrder(root.right, level - 1);
    }

    /**
     * 递归方法计算树深度
     */
    private static int depthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = depthRec(root.left);
        int r = depthRec(root.right);

        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    /**
     * 非递归方法计算深度
     * 想法与层序遍历的非递归方法类似
     * 利用队列的先进先出特性
     * 队列中的结构始终是一层的元素加上已经出队的当前层的元素的左右子树
     * 如果一层出队完成，那么队列中的元素就是下一层元素的总个数
     */
    private static int depthIte(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.offer(root);
        // current：记录本层已经遍历的节点个数  last：当这一层的节点的总个数
        int current, last;
        int level = 0;
        while (!queue.isEmpty()) {
            current = 0;
            last = queue.size();
            // 注意条件判断，current是从0开始
            // current是已经出队的个数，如果与last就无法再出栈了
            while (current < last) {
                cur = queue.poll();
                // 出队一个元素current++
                current++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 每遍历完一层，level++
            level++;
        }
        return level;
    }

    /**
     * 层序遍历，非递归方法
     * 利用队列这个先进先出的数据结构
     * 入队的时候就是按照层的顺序入队，出队也 非常方便
     * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
     */
    public static void levelOrderIte(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur;
        // LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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
}
