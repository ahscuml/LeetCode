import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 倒着层序遍历二叉树
 *
 * @author ahscuml
 * @date 2019/4/29
 * @time 12:09
 */
public class Q107BinaryTreeLevelOrderTraversalII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // TODO
    }

    /**
     * 后序遍历的递归实现，记录层数，确定添加元素的位置
     */
    public static List<List<Integer>> levelOrderBottomII(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    /**
     * 层序遍历循环方法
     * 最后将结果逆序有两种方法，一种是规定好插入的位置，在第一个，另外一种是使用Collections.reverse()函数
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> templist = new ArrayList();
            int count = queue.size();
            while (count > 0) {
                cur = queue.poll();
                templist.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            if (templist != null)
                list.add(0, templist);
        }
        return list;
    }
}


