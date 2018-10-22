/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 21:11
 */
public class Q198HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    /**
     * 当前元素的最大值与之前的最大值有关系，与152题类似
     * 当前元素最大值为max(前一元素最大值，当前元素加上前一元素最大值)
     */
    public static int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    /*public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int maxpre = nums[0], maxbeh = nums[1];
        int res = Math.max(maxpre,maxbeh);
        for(int i = 2; i < nums.length; i++) {
            int temp = maxbeh;
            maxbeh = Math.max(maxpre + nums[i], maxbeh);
            maxpre = Math.max(temp,maxpre);
            res = Math.max(res,maxbeh);
        }
        return res;
    }*/

}
