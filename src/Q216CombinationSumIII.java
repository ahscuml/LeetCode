import java.util.ArrayList;
import java.util.List;

/**
 * 216.Combination Sum III
 *
 * @author ahscuml
 * @date 2018/9/14
 * @time 19:37
 */
public class Q216CombinationSumIII {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7).toString());
    }

    public static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> list = new ArrayList();
        backTracking(list, new ArrayList(), k, target, 1);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int k, int target, int start) {
        if(templist.size() == k && target == 0) {
            list.add(new ArrayList(templist));
        } else if(templist.size() >= k || target <= 0) {
            return;
        } else {
            for(int i = start; i <= 9; i++) {
                templist.add(i);
                backTracking(list, templist, k, target - i, i + 1);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
