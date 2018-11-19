/**
 * 圆形抢劫
 *
 * @author ahscuml
 * @date 2018/11/19
 * @time 21:52
 */
public class Q213HouseRobberII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 已经有了198题的处理方法，所以分两种情况考虑
     */
    public static int rob(int[] nums) {
        // 注意nums.length == 1这个关键点
        if (nums.length == 1) {
            return nums[0];
        }
        // 抢第一个，不抢最后一个
        int pre1 = 0;
        int beh1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = beh1;
            beh1 = Math.max(beh1, pre1 + nums[i]);
            pre1 = temp;
        }
        int res1 = beh1;
        // 不抢第一个，最后一个随意
        int pre2 = 0;
        int beh2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = beh2;
            beh2 = Math.max(beh2, pre2 + nums[i]);
            pre2 = temp;
        }
        int res2 = beh2;

        return Math.max(res1, res2);
    }
}
