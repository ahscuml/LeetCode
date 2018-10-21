import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/description/
 *
 * @author ahscuml
 * @date 2018/10/21
 * @time 10:53
 */
public class Q401BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

    /**
     * 利用17题的思路
     * 计算H的可能性，存储在List中，计算M的可能性，存储到List中，然后再组合到一起
     * */
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        int[] nums1 = {8, 4, 2, 1};
        int[] nums2 = {32, 16, 8, 4, 2, 1};

        for (int i = 0; i <= num; i++) {
            // 暂时存到了两个List中
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for (int num1 : list1) {
                // 小时超出界限
                if (num1 >= 12) continue;
                for (int num2 : list2) {
                    // 分钟超出界限
                    if (num2 >= 60) continue;
                    // 对最终结果做处理
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private static List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    /**
     * @param nums 计算的是H或者M
     * @param count 计算可以使用的数字个数
     * @param pos
     * @param sum 当前的数字组合的和
     * @param res 存储结果的链表
     * */
    private static void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
}
