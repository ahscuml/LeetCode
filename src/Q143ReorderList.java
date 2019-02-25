/**
 * @author ahscuml
 * @date 2019/2/25
 * @time 15:44
 */
public class Q143ReorderList {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        reorderList(listNode1);
        ListNode cur = listNode1;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 按照步骤思路明确
     * */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 第一步：找到中间位置
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 第二步：后面逆序（逆序一个链表）
        // 第一种方法是先将后面的链表逆序，然后将逆序之后的接到前面
        // 这个方法需要考虑到如果是1个或者两个的情况
        ListNode middle = slow;
        ListNode cur = middle.next;
        ListNode then = cur.next;
        while (then != null) {
            cur.next = then.next;
            then.next = middle.next;
            middle.next = then;
            then = cur.next;
        }

        // 第三步：从头遍历，然后拼接
        ListNode curFast = head;
        ListNode curSlow = middle.next;
        while (curFast != middle) {

            middle.next = curSlow.next;
            curSlow.next = curFast.next;
            curFast.next = curSlow;
            curFast = curFast.next.next;
            curSlow = middle.next;
        }
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
