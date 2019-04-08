import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ahscuml
 * @date 2019/4/8
 * @time 23:58
 */
class LRUCache {
    // 定义LRUCache的一些常量参数
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final HashMap<Integer, Node> map;
    final int capacity;

    // 对于LRU初始化
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.pre = head;
    }

    // 插入一个元素到队列的头结点
    private void insertToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    // 从队列里删除一个节点
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = value;
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                // 只有到达容量的时候才移动
                remove(tail.pre);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertToHead(node);
        }
    }

    // 创建一个node对象，方便进行插入删除
    // 这一一个双端队列
    class Node {
        Node pre, next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}




/**
 * 采用LinkedHashMap的方式，非常简单。
 * */
class LRUCacheII {
    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCacheII(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}