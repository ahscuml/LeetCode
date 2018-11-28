/**
 * @author ahscuml
 * @date 2018/11/28
 * @time 19:56
 */
public class Q7ReverseInteger {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int x = 1234987;
        System.out.println(reverse(x));
        System.out.println(reverseII(x));
        int y = -234212;
        System.out.println(reverse(y));
        System.out.println(reverseII(y));
        int z = 1232783879;
        System.out.println(reverse(z));
        System.out.println(reverseII(z));

    }

    /**
     * 首先是翻转一个数，这是一个问题，针对翻转的问题，解决的办法很多
     * 这道题还要判断溢出的问题，有两个方法，下面这个是比较机智的方法，如果溢出那么计算之后的结果和计算之前的结果不一样
     */
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    /**
     * 这个方法就比较普通
     */
    public static int reverseII(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
            if (Math.abs(res) > Math.pow(2, 31) / 10 && x != 0) {
                return 0;
            }

        }
        return res;
    }
}
