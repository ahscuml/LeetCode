/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 19:09
 */
public class Q160IntersectionofTwoLinkedLists {
    public static void main(String[] args) {
        // 1>4,2>3>4 应该返回4
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode4;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(getIntersectionNode(listNode1, listNode2).val);
        System.out.println(getIntersectionNodeII(listNode1, listNode2).val);
    }

    /**
     * 链表的节点可以直接用==来进行比较的
     * 主要纠结的内容是两个链表长度不同，不方便进行比较，但是两个链表接起来的长度就相等了，也就方便比较了。
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /**
     * 另外一种循环的方法就是首先求出两个链表的长度，然后调整到一样长的地方在走，直到找到相同的那个节点
     */
    public static ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int alen = len(headA);
        int blen = len(headB);
        while (alen > blen) {
            headA = headA.next;
            alen--;
        }
        while (blen > alen) {
            headB = headB.next;
            blen--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static int len(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
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
