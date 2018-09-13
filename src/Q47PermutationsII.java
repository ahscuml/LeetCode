import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 21:38
 */
public class Q47PermutationsII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums).toString());
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), new ArrayList<>(), nums);
        return list;
    }

    /**
     * @param list 需要返回的数列
     * @param templist 一次迭代过程中暂时存储的链表
     * @param count 用于记录使用过的元素的下标
     * @param nums 用于迭代的数组
     * */
    public static void backTracking(List<List<Integer>> list, List<Integer> templist, List<Integer> count, int[] nums) {
        if (templist.size() == nums.length) {
            list.add(new ArrayList<>(templist));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !count.contains(i - 1)) {
                    continue;
                }
                if (count.contains(i)) {
                    continue;
                }
                count.add(i);
                templist.add(nums[i]);
                backTracking(list, templist, count, nums);
                templist.remove(templist.size() - 1);
                count.remove(count.size() - 1);
            }
        }
    }
}
