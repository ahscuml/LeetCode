import java.util.ArrayList;
import java.util.List;

/**
 * 357.CountNumberswithUniqueDigits
 *
 * @author ahscuml
 * @date 2018/9/14
 * @time 22:08
 */
public class Q357CountNumberswithUniqueDigits {
    public static void main(String[] args) {
        int N = 2;
        System.out.println(countNumbersWithUniqueDigits(N));
    }

    private static int count = 0;
    public static int countNumbersWithUniqueDigits(int N) {
        if(N == 0) {
            return 1;
        }

        // 遍历位数
        for(int i = 1; i <= N; i++) {
            backTracking(i, new ArrayList());
        }
        return count;
    }
    // 求不相同的数字的个数
    public static void backTracking(int n, List<Integer> number) {
        if(number.size() == n) {
            count += 1;
            return;
        }
        for(int i = 0; i <= 9; i++) {
            if (number.size() > 0 && number.get(0) == 0 && n != 1) {
                return;
            } else if(number.contains(i)){
                continue;
            } else {
                number.add(i);
                backTracking(n, number);
                number.remove(number.size() - 1);
            }
        }
    }
}
