package TEST;

import java.util.Stack;

/**
 * 栈构建队列
 *
 * @author ahscuml
 * @date 2018/10/22
 * @time 11:13
 */
public class StackforQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        StackforQueue stackforQueue = new StackforQueue();
        stackforQueue.push(5);
        stackforQueue.push(3);
        System.out.println(stackforQueue.pop());
        System.out.println(stackforQueue.pop());
    }

    /**
     * 入队操作
     */
    private void push(int num) {
        stackA.add(num);
    }

    /**
     * 出队操作
     */
    private int pop() {
        if (stackB.isEmpty()) {
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 复制转移操作，将栈A的元素复制到栈B中
     */
    private void transfer() {
        if (stackA.isEmpty()) {
            throw new RuntimeException("队列为空，操作失败");
        } else {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }
}
