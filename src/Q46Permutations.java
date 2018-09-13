import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46.Permutations
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 21:02
 */
public class Q46Permutations {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), nums);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int[] nums) {
        if (templist.size() == nums.length) {
            list.add(new ArrayList<>(templist));
        } else {
            for (int i =0; i < nums.length; i++) {
                if (templist.contains(nums[i])) {
                    continue;
                }
                templist.add(nums[i]);
                backTracking(list, templist, nums );
                templist.remove(templist.size() - 1);
            }
        }

    }
}
