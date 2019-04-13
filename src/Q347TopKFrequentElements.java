import java.util.*;

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
     * 使用桶排序来做这件事情
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
        // 如何遍历HashMap也是一个重点
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

    /**
     * 使用堆来完成任务，也就是PriorityQueue
     * */
    public static List<Integer> topKFrequentII(int[] nums, int k) {
        // 利用HahsMap来存储频次
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // 优先队列的使用
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    /**
     * 使用TreeMap来完成这个任务
     * */
    public static List<Integer> topKFrequentIII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        // 对于TreeMap的使用
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
