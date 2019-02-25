/**
 * @author ahscuml
 * @date 2019/2/25
 * @time 11:25
 */
public class Q92ReverseLinkedListII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode result = reverseBetween(a, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 重点是处理好旋转的过程，画出来一步一步分析以及旋转的次数
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
