/**
 * 最长上升子序列
 * 参考这个网址的答案，非常详细。https://segmentfault.com/a/1190000003819886
 *
 * @author ahscuml
 * @date 2019/1/22
 * @time 14:53
 */
public class Q300LongestIncreasingSubsequence {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 101, 3, 7, 5, 18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISDp(nums));
    }

    /**
     * 动态规划方法
     */
    public static int lengthOfLISDp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 构建最长升序序列长度的数组
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // 找到dp[0]到dp[i-1]中最大的升序序列长度且nums[j]<nums[i]
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j]);
                }
            }
            // 加1就是该位置能构成的最长升序序列长度
            lis[i] += 1;
            // 更新全局长度
            max = Math.max(max, lis[i]);
        }
        return max;
    }

    /**
     * 计算的方法
     */
    public static int lengthOfLIS(int[] nums) {
        // tails[i]表示长度为i的升序序列其末尾的数字
        int[] tails = new int[nums.length];
        // 最长子序列长度
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                // 二分搜索，结束条件i == j
                int m = (i + j) / 2;
                // 末尾数字比x还小，证明还有增长的空间
                if (tails[m] < x)
                    i = m + 1;
                // 如果跟x相等或者比x还大证明还可以再小
                else
                    j = m;
            }
            // 上面二分搜索的结果是，i == j，同时这个位置的值是在tail中比x小的最大的值
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}
