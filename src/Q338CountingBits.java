import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 20:25
 */
public class Q338CountingBits {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println();
        System.out.println(Arrays.toString(countBitsII(num)));
    }

    /**
     * 对bit的操作
     * 我的想法是找到了规律
     */
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num == 0) {
            return res;
        }
        res[1] = 1;
        if (num == 1) {
            return res;
        }

        for (int i = 2; i <= num; i++) {
            int front = i % 2;
            int beh = i / 2;
            res[i] = res[front] + res[beh];
        }
        return res;
    }

    /**
     * 对位的操作
     */
    public static int[] countBitsII(int num) {
        int[] counts = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            // 和我发现的规律一样，只不过用 >> 这个方法做起来更简单了
            // >>操作就相当于除2， i & 1就相当于对2求余数
            counts[i] = counts[i >> 1] + (i & 1);
        }
        return counts;
    }
}
