/**
 * @author ahscuml
 * @date 2018/9/30
 * @time 10:12
 */
public class Q24SwapNodesinPairs {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = new ListNode(0);
        result = swapPairs(listNode1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println("");
        result = swapPairsII(listNode2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    /**
     * 根据题目可以知道相当于重复操作，不断交换相邻的两个元素，可以想到递归的方法
     * 同时也可以使用交换的方法，循环操作
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            // 与后面相连
            first.next = second.next;
            // 交换位置
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * 采用递归的方法，重复计算
     */
    public static ListNode swapPairsII(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
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
