/**
 * 21. Merge Two Sorted Lists
 * @author ahscuml
 * @date 2018/9/29
 * @time 15:16
 */
public class Q21MergeTwoSortedLists {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = new ListNode(0);
        result = mergeTwoLists(listNode1, listNode4);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
    /**
     * 递归，相当优秀
     * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
