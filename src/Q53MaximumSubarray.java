/**
 * @author ahscuml
 * @date 2018/10/13
 * @time 13:13
 */
public class Q53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    /**
     * 最优化问题：DP算法 关键是找到sub problem！！！
     * */
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0], n = nums.length,max = sum;
        for(int i = 1; i < n; i++) {
            sum = sum > 0 ? nums[i] + sum : nums[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}
