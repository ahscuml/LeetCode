import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/1/22
 * @time 9:27
 */
public class Q279PerfectSquares {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int count[] = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <=i; j++) {
                count[i] = Math.min(count[i],count[i - j * j] + 1);
            }
        }
        return count[n];
    }
}
