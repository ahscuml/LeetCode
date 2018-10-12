/**
 * @author ahscuml
 * @date 2018/10/12
 * @time 19:36
 */
public class Q234PalindromeLinkedList {
    /**
     * 反转后面的链表，然后方便比较
     * */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        // 通过步数不一样的两个指针，达到找到中间的目的
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 一定要考虑好边界条件
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    /**
     * 反转链表的函数
     * */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

