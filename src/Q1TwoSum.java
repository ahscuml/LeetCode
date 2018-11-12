import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * 
 * @author ahscuml
 * @date 2018/9/19
 * @time 20:25
 */
public class Q1TwoSum {
    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
       int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such solution");
    }

}
