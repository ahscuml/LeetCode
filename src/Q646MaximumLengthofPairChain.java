import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/1/22
 * @time 16:45
 */
public class Q646MaximumLengthofPairChain {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));
        System.out.println(findLongestChainII(pairs));
    }

    /**
     * 动态规划算法
     * 与279题非常类似，方法都是差不多的。
     */
    public static int findLongestChain(int[][] pairs) {
        // 是按照第一个数字进行排序的
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        // 到达当前pair的最长的个数
        Arrays.fill(dp, 1);
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }
        int ans = 0;
        for (int x : dp) {
            if (x > ans) {
                ans = x;
            }
        }
        return ans;
    }

    /**
     * 贪婪算法
     */
    public static int findLongestChainII(int[][] pairs) {
        // 是按照第二个数字进行排序的
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                end = pair[1];
                count++;
            }
        }
        return count;
    }
}
