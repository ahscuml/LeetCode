import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/1/4
 * @time 10:08
 */
public class Q100SameTree {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;

        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        q1.left = q2;
        q1.right = q3;

        System.out.println(isSameTreeRec(p1,q1));
        System.out.println(isSameTreeIte(p1,q1));
    }

    /**
     * 递归的方法遍历这两个树
     * */
    public static boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }

    /**
     * 循环的方法来遍历树，同时只使用一个queue非常简洁，但是对于null的判断会增加时间复杂度。
     * */
    public static boolean isSameTreeIte(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
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
