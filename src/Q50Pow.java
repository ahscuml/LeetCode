/**
 * @author ahscuml
 * @date 2019/4/1
 * @time 22:12
 */
public class Q50Pow {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 非常奇葩的一道题，还要考虑到n是最小值的问题
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(1 / (x * x), -(n / 2));
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
