import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2019/1/2
 * @time 17:05
 */
public class Q347TopKFrequentElements {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

    /**
     * 利用HashMap统计频次
     * 利用List的数组存储结果
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        // 将数组存储到HashMap中统计频率
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 遍历存有频率的HashMap,利用存有list的数组bucket 按照频率将元素存储到bucket里
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i : map.keySet()) {
            int fre = map.get(i);
            if (bucket[fre] == null) {
                bucket[fre] = new LinkedList();
            }
            bucket[fre].add(i);
        }

        // 从bucket中从大到小取出结果
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return res;
    }
}
