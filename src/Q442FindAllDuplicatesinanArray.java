import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/9/19
 * @time 20:07
 */
public class Q442FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums).toString());
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return list;
    }
}
