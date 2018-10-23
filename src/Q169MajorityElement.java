/**
 * @author ahscuml
 * @date 2018/10/23
 * @time 16:53
 */
public class Q169MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    /**
     *  我自己用的方法是使用一个哈希表来存储元素出现的次数，这种空间复杂度O(n)
     *  这个方法在 http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     *  这个方法很简单，利用了数据超过了一半这个信息(一定会超过一半)。
     * */
    public static int majorityElement(int[] nums) {
        int count = 0, maj = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                maj = nums[i];
                count++;
            } else if(maj != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return maj;
    }
}
