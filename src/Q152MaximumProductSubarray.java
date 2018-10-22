/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 20:24
 */
public class Q152MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    /**
     * 正的乘以正的还是正的，负的乘以负的变成正的
     */
    public static int maxProduct(int[] nums) {
        int res = nums[0], max = res, min = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int temp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(temp * nums[i], nums[i]);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
