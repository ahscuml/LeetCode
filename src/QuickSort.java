import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/9/14
 * @time 9:52
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if(right <= left) {
            return;
        }
        int v = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
