import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.CombinationSumII
 * 回溯法
 * 1.确定解空间（这一步很关键，关系到能不能得到正确的解）
 * 2.确定搜索规则
 * 3.进行减枝
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
                // 针对start进行判断，因为start相当于查找的树的层数，i是查找这一层的第几个数
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
