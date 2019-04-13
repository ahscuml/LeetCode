import util.ListNode;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 10:49
 */
public class Q328OddEvenLinkedList {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // TODO
    }

    /**
     * 重点是循环条件的判断
     * */
    public static ListNode oddEvenListII(ListNode head) {
        // 先找到odd和even的开头？？
        if(head == null || head.next == null) {
            return head;
        }
        ListNode even = head.next, curOdd = head, curEven = head.next;
        while(curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;
            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = even;
        return head;
    }


    /**
     * 这个不是这道题的答案，这个是这个题的变种，关注的是listnode中的值
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean isSwaped = false;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        do {
            isSwaped = false;
            cur = dummyHead;
            while (cur.next.next != null) {
                if (cur.next.val % 2 == 0 && cur.next.next.val % 2 == 1) {
                    swapNode(cur, cur.next, cur.next.next);
                    isSwaped = true;
                }
                cur = cur.next;
            }
        } while (isSwaped);
        return dummyHead.next;
    }

    private void swapNode(ListNode pre, ListNode left, ListNode right) {
        left.next = right.next;
        right.next = left;
        pre.next = right;
    }
}
