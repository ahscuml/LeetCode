import java.util.Arrays;

/**
 * @author ahscuml
 * @date 2018/10/23
 * @time 16:53
 */
public class Q169MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementII(nums));
    }

    /**
     *  我自己用的方法是使用一个哈希表来存储元素出现的次数，这种空间复杂度O(n)
     *  下面这个方法更简单一点
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

    /**
     * 如果一定存在多于一半的数的话，那么可以对原数组排序，中间的数字一定就是多于一半的数
     * */
    public static int majorityElementII(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
