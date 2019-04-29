import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/4/29
 * @time 12:22
 */
public class Q637AverageofLevelsinBinaryTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 层序遍历，统计这一层的值，除就可以了
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            int n = count;
            double sum = 0;
            while (count > 0) {
                cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            list.add(sum / n);
        }
        return list;
    }
}
