import java.util.Stack;

/**
 * @author ahscuml
 * @date 2018/11/12
 * @time 14:54
 */
public class Q402RemoveKDigits {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }

    /**
     * 利用贪心算法，求出局部最优解，最终得到全局最优解
     * 如果左边的元素比右边的元素大，那么就可以删除左边的元素，因为右边的元素会顶替左边的元素
     * 使得原数字变小
     * 时间复杂度O(kn)
     * */
    /*public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == len) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 1; i <= k; ) {
            int t = i;
            for (int j = 0; j < sb.length() - 1; j++) {
                if(sb.charAt(j) > sb.charAt(j + 1)) {
                    sb.deleteCharAt(j);
                    i++;
                    break;
                }
            }
            if(t == i) {
                sb.deleteCharAt(sb.length() - 1);
                i++;
            }
        }
        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        if(sb.length() > 0){
            return sb.toString();
        } else {
            return "0";
        }
    }*/

    /**
     * 在贪心算法中时间复杂度太高，因为每一次删除元素都要去遍历一遍数组，这里可以优化为从删除元素处继续遍历
     * 可以利用堆栈的结构来解决这个问题
     * */
    public static String removeKdigits(String num, int k) {
        //删除后剩余数字的个数，也是剩余字符串的长度
        int digits = num.length() - k;
        // 利用数组建立一个长度为数字长度的栈
        char[] stack = new char[num.length()];
        // top是栈中栈顶 + 1的位置
        int top = 0;
        // 对于原数字字符串进行遍历
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // top > 0 证明栈内有东西，k > 0 证明还需要删除元素，stack[top - 1] > c证明栈顶元素比当前元素大，则删除栈顶元素
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        // 到这里就对于原字符串遍历完成，可以保证栈内元素是由大到小排列的
        // 接下来就要对栈内元素进行处理，得到最终结果
        int index = 0;
        // 消除前缀的0
        while (index < digits && stack[index] == '0') {
            index++;
        }
        // 如果index 与 digits相等，那么原来的元素全是0，就返回0，其余返回栈中的除0后的元素
        return index == digits ? "0" : new String(stack,index,digits - index);
    }
}
