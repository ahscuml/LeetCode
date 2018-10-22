/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 20:51
 */
public class Q628MaximumProductofThreeNumbers {
    public static void main(String[] args) {
       int[] nums = {1,2,3};
        System.out.println(maximumProduct(nums));
    }

    /**
     * 这道题比较简单，由于规定了三个数字最大乘积，考虑到负数，只能是三个最大的数相乘或者两个最小的乘以最大的
     * 我的方法是采用了排序算法，但是虽然看起来很简单，但是我排序了中间没有意义的一些元素，所以浪费了时间
     * 最佳的方法是遍历数组，找出三个最大的与两个最小的，这样子的时间复杂度是O(N)
     */
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
    /*public int maximumProduct(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            throw new RuntimeException("输入错误");
        }
        Arrays.sort(nums);

        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3] , nums[0] * nums[1] * nums[n - 1]);
    }*/
}
