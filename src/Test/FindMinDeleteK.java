package Test;

/**
 * 题目描述：N个数字组成的字符串，要求删除K个数字，然后剩下的数字最小。
 * 由于可能超过最大的数值，所以采用字符串表示。
 * @author ahscuml
 * @date 18-11-12
 * @time 下午12:01
 */
public class FindMinDeleteK {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        String num = "3435479857";
        int k = 5;
        int n = num.length();
        int count = n - k;
        findMin(num,n - k,0, n-k);
        System.out.println(res);
    }

    /**
     * 主要的思路就是利用迭代，每一次找到前面最小，然后将最小的元素组合起来
     * 剩余的就是不需要的元素
     * @param num 要删除的字符串
     * @param count 需要找到的最小的数的个数
     * @param start 剩余字符串的起始位置
     * @param end 剩余字符串的结束位置，这个位置可以选择最小
     * */
    static String res = "";
    private static void findMin(String num, int count, int start, int end) {

        if(count == 0) {
            return;
        } else {
            int temp = num.charAt(start);
            int pos = start;
            for(int i = start; i <= end; i++) {
                if((int)num.charAt(i) < temp ){
                    temp = num.charAt(i);
                    pos = i;
                }
            }
            res += temp;
            count--;
            pos++;
            end++;
            findMin(num, count, pos,end);
        }
    }
}

