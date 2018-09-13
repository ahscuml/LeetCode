import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.SubsetsII
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 20:50
 */
public class Q90SubsetsII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetWithDup(nums).toString());
    }

    /**
     *
     * */
    public static List<List<Integer>> subsetWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /**
     *
     * */
    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int[] nums, int start) {
        list.add(new ArrayList<>(templist));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            } else {
                templist.add(nums[i]);
                backTracking(list, templist, nums, i + 1);
                templist.remove(templist.size() - 1);
            }
        }
    }

}
