import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2019/1/22
 * @time 17:16
 */
public class Q673NumberofLongestIncreasingSubsequence {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums));
    }

    /**
     * 动态规划的方法，与300题类似
     */
    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    // 以j为结尾的最长子序列还可以更长
                    if (lengths[i] >= lengths[j]) {
                        // 长度加一
                        lengths[j] = lengths[i] + 1;
                        // 同时次数也和count[i]一样
                        counts[j] = counts[i];
                        //如果i加上J以后和j的最长子序列相同
                    } else if (lengths[i] + 1 == lengths[j]) {
                        // 这样就是相加的关系
                        counts[j] += counts[i];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; i++) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
