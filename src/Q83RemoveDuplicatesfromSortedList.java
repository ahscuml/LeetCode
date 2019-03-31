import util.ListNode;

/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 0:09
 */
public class Q83RemoveDuplicatesfromSortedList {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode cur = deleteDuplicatesII(l1);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }

    /**
     * 递归的方法，非常不建议使用，因为会产生栈的溢出
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 常规的解法，时间复杂度O(n),空间复杂度O(1)
     */
    public static ListNode deleteDuplicatesII(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
