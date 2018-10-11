/**
 * 209. Minimum Size Subarray Sum
 *
 * @author ahscuml
 * @date 2018/10/2
 * @time 11:58
 */
public class Q209MinimumSizeSubarraySum {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }

    /**
     * 滑动窗口
     */
    public static int minSubArrayLen(int s, int[] nums) {
        // 滑动窗口问题
        // result 设置为数组长度加一方便判断是否有解
        int l = 0, r = -1, result = nums.length + 1, sum = 0;
        // 循环结束条件是左边还能取值
        while (l < nums.length) {
            // 滑动窗口为[l,r]双闭区间
            // 方括号取值的时候还要判断是否能取到值
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                result = Math.min(result, r - l + 1);
            }
        }
        // 处理没有解的情况
        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }
}
