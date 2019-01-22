/**
 * 与300题类似，只不过这道题只要求判断是否存在长度为3的最长子序列
 *
 * @author ahscuml
 * @date 2019/1/22
 * @time 15:55
 */
public class Q334IncreasingTripletSubsequence {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
        System.out.println(increasingTripletII(nums));
    }

    /**
     * 利用300题的做法，判断是否有size == 3
     * 不过这种做法时间复杂度不好
     */
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tail[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tail[i] = num;
            if (i == size) {
                size++;
                if (size == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 可以针对这道题的特点，采用时间复杂度更小的方法
     */
    public static boolean increasingTripletII(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min)
                min = num;
            else if (num < secondMin)
                secondMin = num;
            else if (num > secondMin)
                return true;
        }
        return false;
    }
}
