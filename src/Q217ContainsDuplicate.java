import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 *
 * @author ahscuml
 * @date 2018/9/19
 * @time 19:21
 */
public class Q217ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {};
        int[] nums1 = {1,2};
        int[] nums2 = {1,1,2,3,};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate2(nums1));
        System.out.println(containsDuplicate2(nums2));
    }

    /**
     * 方法一：利用排序，然后检查一遍看看是否有重复的，时间复杂度O(NlogN),空间复杂度O(1)
     * */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：利用set的特点来判断是否有重复的元素 时间复杂度O(N),空间复杂度同样是O(N),牺牲空间换取时间上的减少
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
