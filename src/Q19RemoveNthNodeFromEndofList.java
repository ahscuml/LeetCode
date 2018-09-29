/**
 * 19. Remove Nth Node From End of List
 *
 * @author ahscuml
 * @date 2018/9/29
 * @time 9:37
 */
public class Q19RemoveNthNodeFromEndofList {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        removeNthFromEnd(listNode1, 2);
        while (listNode1 != null) {
            System.out.print(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     *
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            end = end.next;
            start = start.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }

    /**
     * 链表的定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
