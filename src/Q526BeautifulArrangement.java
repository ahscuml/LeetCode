import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/9/14
 * @time 20:52
 */
public class Q526BeautifulArrangement {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countArrangement(3));
    }
    private static int count = 0;
    public static int countArrangement(int n) {
        backTracking(n, new ArrayList());
        return count;
    }

    // 在加入进list之前就判断可不可以整除，然后结束条件就是templist的长度是n
    public static void backTracking(int n, List<Integer> templist) {
        if(templist.size() >= n) {
            count += 1;
            return;
        } else {
            for(int i = 1; i <= n; i++) {
                if(templist.contains(i)) {
                    continue;
                }
                if(i % (templist.size() + 1) == 0 || (templist.size() +1) % i == 0 ) {
                    templist.add(i);
                    backTracking(n, templist);
                    templist.remove(templist.size() - 1);
                }
            }
        }
    }
}


// 别人的想法
// 利用从1到N的这个特性，从数组里选出合适的数字放到合适的地方，利用下标来进行判断。 可以极大降低计算量，因为计算过的数后面就不用计算了
/*
class Solution {
    private int count = 0;
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void dfs(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) dfs(nums, start-1);
            swap(nums,i, start);
        }
    }
    public int countArrangement(int N) {
        if (N == 0) return 0;
        int[] nums = new int[N+1];
        for (int i = 0; i <= N; i++) nums[i] = i;
        dfs(nums, N);
        return count;
    }
}*/
