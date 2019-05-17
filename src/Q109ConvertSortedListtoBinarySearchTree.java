import util.ListNode;
import util.TreeNode;

/**
 * 把一个有序链表变成二叉查找树
 *
 * @author ahscuml
 * @date 2019/5/18
 * @time 1:00
 */
public class Q109ConvertSortedListtoBinarySearchTree {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 思路很简单和108题对应，但是108题中的array可以用index来找到中间值，list只能使用双指针这个方法
     * 同样这个里面有很多的细节
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head, slow = head, last = slow;
        // 利用这种判断方法可以保障fast不是空
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        }
        // 分裂为两个list
        fast = slow.next;
        last.next = null;
        TreeNode cur = new TreeNode(slow.val);
        if (head != slow) {
            cur.left = sortedListToBST(head);
        }
        cur.right = sortedListToBST(fast);
        return cur;
    }

    /**
     * 跟上面的思路是一样的，但是分成了两个方法，更加好理解
     */
    public TreeNode sortedListToBSTII(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}
