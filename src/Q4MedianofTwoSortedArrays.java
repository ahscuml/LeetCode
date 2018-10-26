import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/10/25
 * @time 21:32
 */
public class Q4MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    /**
     *
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        for(int i = 0; i < n1; i++) {
            nums[i] = nums1[i];
        }
        for(int i = 0; i < n2; i++) {
            nums[i + n1] = nums2[i];
        }
        Arrays.sort(nums);
        if((n1 + n2) % 2 == 0) {
            System.out.println(nums[nums.length / 2] + nums[nums.length / 2 - 1]);
            res = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / (double)2;
        } else {
            res = nums[nums.length / 2];
        }
        return res;
    }
}
