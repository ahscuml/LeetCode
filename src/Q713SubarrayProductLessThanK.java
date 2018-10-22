/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 21:52
 */
public class Q713SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 双指针， 滑动窗口
        int res = 0;
        // 当前的乘积
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            // j每次增加1，窗口每次向后扩大1
            pro *= nums[j];
            // 如果乘积大于K，则将i向前移动
            while (i <= j && pro >= k) {
                pro /= nums[i];
                i++;
            }
            // 每次j都加1，新产生的窗口必须包含j(因为不包含j的窗口在之间已经计算过了) 而且必须是连续的(因为是subArray)
            res += j - i + 1;
        }
        return res;
    }
}
