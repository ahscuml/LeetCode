import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/20
 * @time 21:11
 */
public class Q155MinStack {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {

    }

    /**
     * 重点的问题是O(1)的时间找到min
     * 可以使用两个栈 一个存数据，一个存最小值
     * 也可以使用一个栈 最小值和数据存到一起，可以减少一些空间
     * */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    // 如果x比min小，则将min也压入栈然后再将min赋值成x,再压入x
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    // 出栈的时候，如果弹出的与min相等，则证明现在里面最小的已经不是min了，再弹出一个，这个才是min
    public void pop() {
        int peek = stack.pop();
        if (peek == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
