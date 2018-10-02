/**
 * @author ahscuml
 * @date 2018/10/2
 * @time 11:06
 */
public class Q88MergeSortedArray {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1,m,nums2,n);
        for (int i: nums1) {
            System.out.print(i +", ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针问题
        // i是nums1中的下标，j是nums2中的下标，l是两个数组合并的下标
        int i = m - 1, j = n - 1, l = m + n - 1;
        while(i >=0 && j >= 0) {
            if(nums2[j] > nums1[i]) {
                nums1[l--] = nums2[j--];
            } else {
                nums1[l--] = nums1[i--];
            }
        }
        // 考虑到是否遍历完成的问题，nums1不用考虑，因为元素被放置到nums1中
        while(j >= 0) {
            nums1[l--] = nums2[j--];
        }
    }
}
