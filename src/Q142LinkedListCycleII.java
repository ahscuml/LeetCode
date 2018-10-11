/**
 * @author ahscuml
 * @date 2018/10/11
 * @time 16:43
 */
public class Q142LinkedListCycleII {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(detectCycle(listNode1).val);
    }

    /**
     * 类似于简单的计算题
     * 首先假设头结点到循环点的距离是M，循环的距离是K，第一次相遇点距离循环点L，第一次相遇走过的步数S
     * Walker： S = M + n1*K + L
     * runner: 2S = M + n2*K + L
     * 两式相减 S = (n2 - n1) * K = nK(也就是第一次相遇走过的距离相当于循环了n圈)
     * 那么Walker2从头开始走也就意味着他们会在相同的地点相遇，也会在循环开始的地方第一次相遇
     * */
    public static ListNode detectCycle(ListNode head) {
        // 与判断是否是循环链表一样的判断方法
        ListNode runner = head;
        ListNode walker = head;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            // 表示Walker与runner第一次相遇
            if(walker == runner) {
                // 这时候Walker2从头结点出发，当它与Walker第一次相遇的时候就是循环开始的地方
                ListNode walker2 = head;
                while(walker != walker2) {
                    walker = walker.next;
                    walker2 = walker2.next;
                }
                return walker;
            }
        }
        return null;
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

