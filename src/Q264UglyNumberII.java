/**
 * @author ahscuml
 * @date 2019/1/17
 * @time 16:41
 */
public class Q264UglyNumberII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        System.out.println("第10个丑数是：" + nthUglyNumber(10));
    }

    /**
     * 利用动态规划的方法
     * 特点是：丑数就是2,3,5这三个数字每一个都乘以丑数出来的数值
     * 那么2,3,5分别乘以计算出来的丑数，然后看哪一个最小
     */
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int ind2 = 0, ind3 = 0, ind5 = 0;
        int cur2 = 1, cur3 = 1, cur5 = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = Math.min(Math.min(cur2, cur3), cur5);
            if (ugly[i] == cur2) {
                cur2 = 2 * ugly[ind2++];
            }
            if (ugly[i] == cur3) {
                cur3 = 3 * ugly[ind3++];
            }
            if (ugly[i] == cur5) {
                cur5 = 5 * ugly[ind5++];
            }
        }
        return ugly[n - 1];
    }
}
