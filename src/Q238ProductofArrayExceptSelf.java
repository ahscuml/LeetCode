import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/10/10
 * @time 20:09
 */
public class Q238ProductofArrayExceptSelf {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /**
     * 减少无效的计算来减少时间复杂度
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = 1;
        // 正序乘过去
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }
        int right = 1;
        // 再逆序乘回来
        for (int i = n - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        return arr;
    }
}
