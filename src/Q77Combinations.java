import java.util.ArrayList;
import java.util.List;

/**
 * 77 Combinations
 * @author ahscuml
 * @date 2018/9/15
 * @time 10:42
 */
public class Q77Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k).toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backTracking(list, new ArrayList(), n, k, 1);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> templist, int n, int k, int  start){
        if(templist.size() == k) {
            list.add(new ArrayList(templist));
            return;
        }
        for(int i = start; i <= n; i++){
            if(templist.contains(i)) {
                continue;
            }
            templist.add(i);
            backTracking(list, templist, n, k, i + 1);
            templist.remove(templist.size() - 1);
        }

    }
}
