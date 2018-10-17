/**
 * @author ahscuml
 * @date 2018/10/17
 * @time 18:12
 */
public class Q581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,2};
        System.out.println(findUnsortedSubarray(nums));
    }
    /**
     * 通过一次遍历，同时寻找最大的数与最小的数(通过相反方向的判断来寻找出最终的结果)，同时判断begin和end两个下标
     * */
    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
}
