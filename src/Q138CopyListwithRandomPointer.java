import util.RandomNode;

/**
 * @author ahscuml
 * @date 2019/4/17
 * @time 21:37
 */
public class Q138CopyListwithRandomPointer {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        // TODO
    }

    /**
     *
     * */
    public RandomNode copyRandomList(RandomNode head) {
        if(head == null) {
            return null;
        }
        RandomNode cur = head;
        // 创建新的链表
        while(cur != null) {
            RandomNode newNode = new RandomNode();
            newNode.val = cur.val;
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        cur = head;
        // 复制random节点
        while(cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        RandomNode dummyHead = cur.next;
        // 按照奇偶拆分成两个链表
        while(cur != null) {
            RandomNode newNode = cur.next;
            cur.next = newNode.next;
            newNode.next = cur.next == null ? null : newNode.next.next;
            cur = cur.next;
        }
        return dummyHead;

    }
}
