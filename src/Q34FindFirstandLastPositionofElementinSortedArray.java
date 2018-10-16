import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/10/16
 * @time 9:22
 */
public class Q34FindFirstandLastPositionofElementinSortedArray {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 8, 10};
        int[] nums1 = {8};
        System.out.println(Arrays.toString(searchRange(nums1, 8)));
    }

    /**
     * 利用两个二分查找，第一个查找前面的，第二个查找后面的，利用一个小TRICK，二分查找的深刻理解
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        int i = 0, j = n - 1;
        if (nums == null || nums.length == 0) {
            return res;
        }
        while (i < j) {
            // 注意mid的值，mid是偏左的
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (nums[i] == target) {
            res[0] = i;
        } else {
            return res;
        }
        j = n - 1;
        while (i < j) {
            // 注意mid的值，多加了一个1，保证mid是偏右的
            int mid = (j + i) / 2 + 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        res[1] = j;
        return res;
    }
}
