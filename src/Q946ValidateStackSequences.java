import java.util.Stack;

/**
 * @author ahscuml
 * @date 2019/4/13
 * @time 18:52
 */
public class Q946ValidateStackSequences {
    /**
     *
     * */
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    /**
     * 很简单的思想，不过记得stack要先push
     * */
    public static boolean validateStackSequences(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                j++;
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
