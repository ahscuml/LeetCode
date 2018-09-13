import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.CombinationSumII
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 19:27
 */
public class Q40CombinationSumII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target).toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int[] candidates, int target,
                                    int start) {
        if (target == 0) {
            list.add(new ArrayList<>(templist));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 避免两个相同元素产生两个相同的结果，所以在第一次循环中减少一次查找
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                templist.add(candidates[i]);
                backTracking(list, templist, candidates, target - candidates[i], i + 1);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
