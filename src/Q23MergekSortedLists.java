import util.ListNode;

import java.util.*;

/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 18:19
 */
public class Q23MergekSortedLists {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        //TODO
    }

    /**
     * 看到了merge最先想到的就应该是mergesort，针对链表进行mergesort
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid + 1, end);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(b.next, a);
            return b;
        }
    }

    /**
     * 对于很对元素排序的题还可以应用优先队列，应用优先队列的特性，让优先队列去排序
     * */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        // 优先队列的构造函数，确定大小和初始化构造器，通过构造器来完成排序的工作
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                // lists里面的ListNode只是一个节点，如果当前节点后面还有节点，那么在放入队列的时候将这个节点之后的节点添加进queue
                if (tail.next != null) {
                    queue.add(tail.next);
                }
            }
        }
        return dummy.next;
    }

    /**
     * 还有一种方法，可以把所有的ListNode的值读出来，读到一个list里，然后进行排序，最后从头到尾进行建立ListNode的操作
     * 这种方法竟然打败了
     * */
    public ListNode mergeKListsIII(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while(cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(list);
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for(int i = 0; i < list.size(); i++) {

            cur.next = new ListNode(list.get(i));
            cur = cur.next;
            //cur = null;
        }
        return dummyHead.next;
    }
}
