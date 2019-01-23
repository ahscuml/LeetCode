/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 *
 * 利用动态规划的方法，kadane算法
 *
 * @author ahscuml
 * @date 2018/10/13
 * @time 13:13
 */
public class Q53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayII(nums));
    }

    /**
     * DP算法，利用数组存储计算结果
     * kadane算法
     * */
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp是以当前元素结尾的最大子序列值
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 上面方法的优化，降低空间复杂度
     * 最优化问题：DP算法 关键是找到sub problem！！！
     */
    public static int maxSubArrayII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, sum = nums[0], max = sum;
        for (int i = 1; i < n; i++) {
            sum = sum > 0 ? nums[i] + sum : nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
