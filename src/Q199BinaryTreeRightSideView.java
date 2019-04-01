import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 17:00
 */
public class Q199BinaryTreeRightSideView {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        //TODO
    }

    /**
     * 循环的方式，相当于层序遍历
     * */
    public List<Integer> rightSideView(TreeNode root) {
        // 从右往左看就是将层序遍历的最后一个元素放入这个list中
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> list = new ArrayList();
        if(root == null) {
            return list;
        }
        queue.offer(root);
        while(queue.size() != 0) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if(i == 0) {
                    list.add(cur.val);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return list;
    }

    /**
     * 递归的方法
     * */
    public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
