import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78.Subsets
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 19:59
 */
public class Q78Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int[] nums, int start) {
        list.add(new ArrayList<>(templist));
        for (int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            backTracking(list, templist, nums, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}
