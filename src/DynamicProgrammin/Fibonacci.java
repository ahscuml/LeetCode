package DynamicProgrammin;

/**
 * 斐波那契问题是经典的动态规划问题，可以从这里面学到动态规划的思想
 *
 * 补充1：走台阶，每次可以走1步，或者两步，问有多少种可能
 *
 * 补充2：母牛生产问题，成熟母牛每年生一个小牛小牛三年之后成熟又可以生小牛。第一年有一头牛，
 * 第二年开始生小牛，给定整数N，求N年后牛的数量
 * @author ahscuml
 * @date 19-3-20
 * @time 下午3:14
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib1(8));
        System.out.println(fib2(8));
        System.out.println(cow(5));
    }

    /**
     * 递归的方法来做这个提，从上往下
     * */
    private static int fib1(int n) {
        if(n < 1) {
            return 0;
        } else if(n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1( n - 2);
    }

    /**
     * 动态规划的方法，O(N)的时间复杂度
     * */
    private static int fib2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1, pre = 1;
        for (int i = 3; i <= n; i++) {
            res += pre;
            pre = res - pre;
        }
        return res;
    }

    /**
     * 小牛问题
     * 重点是找到递推的关系式
     * */
    private static int cow(int n) {
        if(n < 1) {
            return 0;
        } else if(n == 1 || n == 2 || n == 3) {
            return n;
        }
        // 前1年
        int n_1 = 3;
        // 前2年
        int n_2 = 2;
        // 前3年
        int n_3 = 1;
        for(int i = 4; i <= n; i++) {
            n_1 = n_1 + n_3;
            int temp = n_2;
            n_2 = n_1 - n_3;
            n_3 = temp;
        }
        return n_1;
    }
}
