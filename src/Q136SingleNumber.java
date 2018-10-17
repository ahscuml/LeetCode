/**
 * @author ahscuml
 * @date 2018/10/17
 * @time 16:45
 */
public class Q136SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 利用异或这个关键词，相同的就会变成0；所以异或到最后就是想要的那个数字
     * */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
