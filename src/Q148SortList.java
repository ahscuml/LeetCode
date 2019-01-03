/**
 * @author ahscuml
 * @date 2019/1/2
 * @time 23:04
 */
public class Q148SortList {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        printListNode(sortListRec(l1));
        System.out.println();
        // printListNode(sortList(l1));
    }

    /**
     * 最终还是没有看懂这个利用循环做的归并排序
     * */
    public static ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 这是一个数组可以存放两个ListNode
        ListNode[] list = new ListNode[2];
        boolean done = (head == null);
        // Keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
        for (int step = 1; !done; step *= 2) {
            done = true;
            ListNode prev = dummyHead;
            ListNode remaining = prev.next;
            do {
                // Split off two sublists of size step
                for (int i = 0; i < 2; i++) {
                    list[i] = remaining;
                    ListNode tail = null;
                    for (int j = 0; j < step && remaining != null; j++, remaining = remaining.next) {
                        tail = remaining;
                    }
                    // Terminate our sublist
                    if (tail != null) {
                        tail.next = null;
                    }
                }

                // We're done if these are the first two sublists in this pass and they
                // encompass the entire primary list
                done &= (remaining == null);

                // 针对list中的两个内容进行交换，merge的过程
                if (list[1] != null) {
                    while (list[0] != null || list[1] != null) {
                        int idx = (list[1] == null || list[0] == null && list[0].val <= list[1].val) ? 0 : 1;
                        prev.next = list[idx];
                        list[idx] = list[idx].next;
                        prev = prev.next;
                    }

                    // Terminate our new sublist
                    prev.next = null;
                } else {
                    // Only a single sublist, no need to merge, just attach to the end
                    prev.next = list[0];
                }
            } while (remaining != null);
        }
        return dummyHead.next;
    }

    /**
     * 递归的方法，同样利用了归并排序，由于使用递归所以空间复杂度不是O(1)
     * 递归调用，两个节点，一个快，一个慢，快的到达末尾，慢的就到达中间
     */
    public static ListNode sortListRec(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode f = head.next.next;
        ListNode p = head;
        while (f != null && f.next != null) {
            p = p.next;
            f = f.next.next;
        }
        // 递归调用 p在链表的中部
        ListNode h2 = sortListRec(p.next);
        // 将一个链表从中间分为两部分 一个是head，一个是h2
        p.next = null;
        return merge(sortListRec(head), h2);
    }

    /**
     * 归并的过程
     */
    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 != null)
            cur.next = h1;
        if (h2 != null)
            cur.next = h2;
        return dummyHead.next;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
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
