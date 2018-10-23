import java.util.HashMap;

/**
 * @author ahscuml
 * @date 2018/10/23
 * @time 15:46
 */
public class Q560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }

    /**
     * 利用哈希表存储0-i的和
     */
    public static int subarraySum(int[] nums, int k) {
        // 利用哈希表存储0-j的和。 key：sum    value:出现的次数
        HashMap<Integer, Integer> preSum = new HashMap();
        // 如果值为0也可以不变，所以要先将0,1 存入到哈希表中
        preSum.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
