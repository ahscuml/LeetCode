import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法
 * 39.CombinationSum
 *
 * @author ahscuml
 * @date 2018/9/13
 * @time 11:01
 */
public class Q39CombinationSum {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target).toString());
    }

    /**
     * 主函数
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     * @param list
     * @param templist   暂存的列表
     * @param candidates 候选数组
     * @param target     目标
     * @param start      遍历初始下标
     */
    public static void backTrack(List<List<Integer>> list, List<Integer> templist, int[] candidates, int target, int
            start) {
        if (target == 0) {
            list.add(new ArrayList<>(templist));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                templist.add(candidates[i]);
                backTrack(list, templist, candidates, target - candidates[i], i);
                templist.remove(templist.size() - 1);
            }
        }

    }
}
