/**
 * 强盗抢劫问题
 * 两种动态规划的想法
 *
 * @author ahscuml
 * @date 2018/10/22
 * @time 21:11
 */
public class Q198HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        System.out.println(robRec(nums));
    }

    /**
     * 非常经典的动态规划问题，首先思考的是递归关系
     * 递归关系是相对来说比较简单的：当前元素最大值为 Math.max(前一元素最大值，当前元素加上前一元素最大值)
     * 采用递归的方法来计算，注意栈的深度，太深则会溢出
     */
    public static int robRec(int[] nums) {
        return robRecHelper(nums, nums.length - 1);
    }

    private static int robRecHelper(int[] nums, int i) {
        // 这个终止条件很关键
        if (i < 0) {
            return 0;
        }
        // 注意递归的终止条件
        return Math.max(robRecHelper(nums, i - 2) + nums[i], robRecHelper(nums, i - 1));
    }


    /**
     * 上一种方法的优化，存储了之前的计算结果，避免重复计算
     * 同时采用了存储的空间换时间的想法，同时采用了循环，避免了递归溢出的问题
     * 当前元素的最大值与之前的最大值有关系，与152题类似
     */
    public static int rob(int[] nums) {
        int pre = 0;
        int beh = 0;
        for(int i : nums) {
            // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
            // pre,beh,i
            int temp = beh;
            beh = Math.max(pre + i, beh);
            pre = temp;
        }
        return  beh ;
    }
}
