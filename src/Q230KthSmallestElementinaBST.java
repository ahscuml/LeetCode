import util.TreeNode;

import java.util.ArrayDeque;

/**
 * @author ahscuml
 * @date 2019/5/17
 * @time 23:14
 */
public class Q230KthSmallestElementinaBST {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {

    }

    /**
     * BST的特点就是中序遍历就是顺序的数组
     * 按照中序遍历的结构来完成
     * */
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    void helper(TreeNode root, int k) {
        if(root != null) {
            kthSmallest(root.left, k);
            if(++count == k) {
                res  = root.val;
            }
            kthSmallest(root.right, k);
        }
    }

    /**
     * 利用循环的方法
     * */
    public int kthSmallestIte(TreeNode root, int k) {
        TreeNode cur = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(--k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            }
        }
        return -1;
    }

    /**
     * 另外一种，利用二分查找，分别统计这个节点的左右节点各有多少个节点，直到找到K个
     * */
    public int kthSmallestIII(TreeNode root, int k) {
        int cnt = count(root.left);
        if(k <= cnt) {
            return kthSmallestIII(root.left, k);
        } else if(k > cnt + 1) {
            return kthSmallestIII(root.right, k - cnt - 1);
        }
        return root.val;
    }

    int count(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
