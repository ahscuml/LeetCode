/**
 * @author ahscuml
 * @date 2018/10/12
 * @time 16:11
 */
public class Q61RotateList {
    // 确定链表长度
    // 1. 找到返回的那个点（最好找到前一个）
    // 2. 最后一个元素指向第一个
    // 3. 返回那个点的前一个指向null


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        int j = count - k % count;
        while (j > 0) {
            slow = slow.next;
            j--;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
