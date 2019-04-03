import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/10/8
 * @time 19:56
 */
public class Q215KthLargestElementinanArray {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int nums1[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int nums2[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int nums3[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int nums4[] = {-1, 0, 2};
        int nums5[] = {1};
        System.out.println(findKthLargest(nums1, 4));
        System.out.println(findKthLargestII(nums2, 1));
        System.out.println(findKthLargestIII(nums5, 1));
        System.out.println(findKthLargestIV(nums3, 4));
        System.out.println(findKthLargestV(nums3, 4));
    }

    /**
     * 想法很简单，通过排序，找到需要的元素，结束
     * 时间复杂度O(NlogN)
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 对于上一个算法的优化，不用将所有的元素排序，只要排到需要的位数就可以了
     * 利用选择排序(排序K次使得前K个元素有序),所以时间复杂度最好是O(N),最差是O(N^2)
     */
    public static int findKthLargestII(int[] nums, int k) {
        final int N = nums.length;
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i; j < N; j++) {
                if (nums[index] < nums[j]) {
                    index = j;
                }
            }
            swap(nums, i, index);
        }
        return nums[k - 1];
    }

    /**
     * 对于选择排序的优化
     * 每次选择排序可以选择出最大与最小，可以根据K的大小找到最大或者最小的来返回
     */
    public static int findKthLargestIII(int[] nums, int k) {
        final int N = nums.length;
        // 找到最大的K，就是找到最小的N-K
        int left = 0, right = N - 1;
        while (left <= right) {
            int maxindex = left, minindex = right;
            if (nums[maxindex] < nums[minindex]) {
                swap(nums, maxindex, minindex);
            }
            for (int i = left + 1; i < right; i++) {
                if (nums[i] > nums[maxindex]) {
                    maxindex = i;
                }
                if (nums[i] < nums[minindex]) {
                    minindex = i;
                }
            }
            swap(nums, maxindex, left);
            swap(nums, minindex, right);
            // 到这里已经确保前[0,left]最大，[right,N-1]最小。
            if (left == k - 1) {
                return nums[left];
            }
            if (left == N - k) {
                return nums[right];
            }
            left++;
            right--;
        }
        //return nums[0];
        throw new RuntimeException("初始化错误");
    }

    /**
     * 快速选择算法 时间复杂度O(N).利用快速排序的思路，不过每一次只遍历一半的元素
     */
    public static int findKthLargestIV(int[] nums, int k) {
        final int N = nums.length;
        return quickSelect(nums, k - 1, 0, N - 1);
    }

    public static int quickSelect(int[] nums, int k, int left, int right) {
        // 避免函数越界
        if (left == right) {
            return nums[left];
        }
        // 随机选择一个数值作为标定点，达到随机化的目的
        // 这个查找只从一边开始，所以速度没有双指针快
        swap(nums, left, (int) Math.random() * (right - left + 1) + left);
        int v = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        if (j < k) {
            return quickSelect(nums, k, j + 1, right);
        } else if (j > k) {
            return quickSelect(nums, k, left, j - 1);
        } else {
            return nums[j];
        }
    }

    /**
     * 同样的快速选择算法 但是在paartition操作中使用了双指针技术，所以会更快一点
     */
    public static int findKthLargestV(int[] nums, int k) {
        return quickSelectII(nums, nums.length - k, 0, nums.length - 1);
    }

    private static int quickSelectII(int[] nums, int k, int left, int right) {
        // 递归的终止条件，同样也是
        if (left >= right) {
            return nums[left];
        }
        // 随机化
        int index = (left + right) / 2;
        int pivot = nums[index];
        int low = left, high = right;
        // partition 操作
        while (low <= high) {
            // 如果左边比pivot小，左边不断增加，直到大于pivot
            while (low <= high && nums[low] < pivot) {
                low++;
            }
            // 如果右边比pivot大，右边不断减少，直到小于pivot
            while (low <= high && nums[high] > pivot) {
                high--;
            }
            // 交换high与low
            if (low <= high) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                low++;
                high--;
            }
        }
        // 针对K进行递归，由于K是对nums的下标来说的，所以K不用变
        if (k >= low && k <= right) {
            return quickSelectII(nums, k, low, right);
        } else if (k >= left && k <= high) {
            return quickSelectII(nums, k, left, high);
        } else {
            return nums[k];
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
