import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * @author ahscuml
 * @date 2019/3/20
 * @time 20:02
 */
public class Q416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition1(nums));
    }

    /**
     * 0-1背包问题的变形 类似于coins问题？？？
     * dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum的末位不能是奇数，因为奇数不可能分成两个相等的内容
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        /**
         * ii的地方全填成false？
         * */
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        // 和为0的
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        // 不使用元素的
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // 不用当前这个元素
                dp[i][j] = dp[i - 1][j];
                // j是sum，
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 上面方法的优化，使用一维数组
     * */
    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        // 数组的初始化
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }
}
