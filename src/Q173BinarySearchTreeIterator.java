import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/5/18
 * @time 0:04
 */
public class Q173BinarySearchTreeIterator {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 把按照顺序遍历的过程通过三个函数展现出来，里面有很多细节的处理
     */
    class BSTIterator {
        private ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            // 先到达最小的子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode n = stack.peek();
            stack.pop();
            int res = n.val;
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
            }
            return res;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


    /**
     * 题目很简单，这个解法是相对笨一点的解法
     */
    class BSTIteratorII {
        Queue<Integer> queue = new LinkedList();

        public void BSTIteratorII(TreeNode root) {
            helper(root);
        }

        void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root.left);
            queue.offer(root.val);
            helper(root.right);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (hasNext())
                return queue.poll();
            return -1;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
