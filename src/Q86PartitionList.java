/**
 * @author ahscuml
 * @date 2018/10/10
 * @time 20:43
 */
public class Q86PartitionList {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = partition(listNode1, 3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    /**
     * 将大的存储在一个线性表中，小的存储在一个线性表中
     * 遍历结束之后通过将大的放在小的后面
     */
    public static ListNode partition(ListNode head, int x) {
        // 将大的存储在一个线性表中，小的存储在一个线性表中
        // 遍历结束之后通过将大的放在小的后面
        ListNode bigHead = new ListNode(0), smallHead = new ListNode(0);
        ListNode bigLast = bigHead, smallLast = smallHead;
        while(head != null) {
            if(head.val < x) {
                smallLast.next = head;
                smallLast = smallLast.next;
            } else {
                bigLast.next = head;
                bigLast = bigLast.next;
            }
            head = head.next;
        }
        bigLast.next = null;
        smallLast.next = bigHead.next;
        return smallHead.next;
    }

    /**
     * 空间复杂度O(1)，时间复杂度O(n)
     * 在链表内部调整，找到一个小的，就把这个小的放到前面。
     * */
    public ListNode partitionII(ListNode head, int x) {
        // 循环的方法
        // 存3个节点，一个是pre，一个cur，还有一个小数字的尾节点
        if(head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        ListNode tail = dummyHead;
        while(cur != null) {
            if(cur.val < x) {
                if(tail == pre) {
                    cur = cur.next;
                    pre = pre.next;
                    tail = tail.next;
                } else {
                    // 摘链
                    pre.next = cur.next;
                    // 插入
                    cur.next = tail.next;
                    tail.next = cur;
                    tail = cur;
                    cur = pre.next;
                }

            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
