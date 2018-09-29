import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * @author ahscuml
 * @date 2018/9/29
 * @time 9:41
 */
public class Q20ValidParentheses {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    /**
     * 比较简单的写法，也是很简单的思路，利用栈来做
     * */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop()!=s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
