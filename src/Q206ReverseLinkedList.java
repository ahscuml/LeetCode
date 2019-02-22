import java.util.HashMap;

/**
 * 反转链表
 * @author ahscuml
 * @date 18-11-3
 * @time 上午11:24
 */
public class Q206ReverseLinkedList {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode head = reverseList(a);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 循环的思路 时间复杂度O(n),空间复杂度O(1)
     * 很简单的想法,存储上一个与当前节点,然后反转
     * 再将当前节点设置为上一个节点，后一个节点设置为当前节点
     * 创建链表的时候可以直接设置为空
     * */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 这是第二种方法 哈希表 时间复杂度O(n),空间复杂度O(n)
     * 将节点存储到哈希表中,再翻转
     * */
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<Integer,ListNode> map = new HashMap();
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        int n = 0;
        while(pointer.next != null) {
            pointer = pointer.next;
            map.put(n,pointer);
            n++;
        }
        n--;
        head = map.get(n);
        pointer = head;
        while(n > 0) {
            n--;
            pointer.next = map.get(n);
            pointer = pointer.next;
        }
        pointer.next = null;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
