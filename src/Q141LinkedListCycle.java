import java.util.List;

/**
 * @author ahscuml
 * @date 2018/10/11
 * @time 16:11
 */
public class Q141LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
        listNode3.next = listNode4;
        System.out.println(hasCycle(listNode1));
        System.out.println(hasCycle(listNode3));

    }

    public static boolean hasCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
