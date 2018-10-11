/**
 * @author ahscuml
 * @date 2018/10/2
 * @time 10:04
 */
public class Q80RemoveDuplicatesfromSortedArrayII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        for (int i = 0; i < removeDuplicates(nums); i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("");
        System.out.println(removeDuplicates(nums));
        System.out.println("-------------");
        int[] nums1 = {};
        for (int i = 0; i < removeDuplicates(nums1); i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println("");
        System.out.println(removeDuplicates(nums1));
    }

    /**
     * 代码真滴简单
     * 思路也很简单，两个指针，一个是当前遍历的位置——n,另外一个是返回数组的位置i,数组为[0,i)
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            // 由于后面用到i-2,所以i>2, n > nums[i-2]判断的是当前元素是否重复
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
    /**
     *
     * */
    /*public static int removeDuplicates(int[] nums) {
        // 问题是如何判断两个相同元素
        // 如果当前元素和前一个元素第一次相等，那么count = 1，在当前和前一个不相等的时候count= 0；
        int count = 0, k = 1;
        if(nums.length == 1 || nums.length == 0) {
            return nums.length;
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1] ) {
                if(count == 0){
                    nums[k] = nums[i];
                    k++;
                }
                count = 1;
            } else {
                count = 0;
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }*/
}
