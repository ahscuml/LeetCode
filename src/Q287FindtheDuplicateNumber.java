/**
 * @author ahscuml
 * @date 2018/10/12
 * @time 20:31
 */
public class Q287FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    /**
     * 类似于旋转链表的那道题 142
     * 关注题目中不一样的部分，那就是题目中数组内容大小有限制，为 1~n。
     * */
    public static int findDuplicate(int[] nums) {
        if (nums.length > 1){
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
