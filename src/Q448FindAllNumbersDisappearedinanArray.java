import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/10/22
 * @time 18:08
 */
public class Q448FindAllNumbersDisappearedinanArray {
    /**
     * 自己的想法是通过交换两个元素，找到元素不对应的下标。但是交换需要三次操作
     * 可以考虑通过给元素正负来判断当前下标是否考虑过，这样只需要一次操作
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // 遍历数组，交换元素位置，使得每一个元素都在自己的值减1处
        // 如果有重复的，那么元素的位置相应的往后移动
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            // 因为下标从0开始，所以存储的内容为i-1
            while (nums[i] != i + 1) {
                // 将位于i位置的元素交换到正确的位置
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                } else {
                    // 进行交换
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    // 注意交换过元素，所以需要使用temp，而不是nums[nums[i] - 1]
                    nums[temp - 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
