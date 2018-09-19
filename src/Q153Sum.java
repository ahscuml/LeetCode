import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * @author ahscuml
 * @date 2018/9/19
 * @time 21:11
 */
public class Q153Sum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

    /**
     * 三个数字相加为0，可以降低维度，先固定一个a,遍历数组计算b + c = -a
     * 遍历的范围(注意不能有重复，所以相同数字只能遍历一遍)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
