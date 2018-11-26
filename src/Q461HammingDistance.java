/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 12:19
 */
public class Q461HammingDistance {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int x = 5, y = 2;
        Q461HammingDistance test = new Q461HammingDistance();
        System.out.println(test.hammingDistance(x, y));
        System.out.println(test.hammingDistanceII(x, y));
    }

    /**
     * 重点是如何将十进制数转化为二进制数
     */
    public int hammingDistance(int x, int y) {
        // 如何将一个数转化为二进制数？
        int count = 0, nums1 = 0, nums2 = 0;
        while (x != 0 || y != 0) {
            nums1 = x % 2;
            x = x / 2;
            nums2 = y % 2;
            y = y / 2;
            if (nums1 != nums2) {
                count++;
            }
        }
        return count;
    }

    /**
     * 移位
     */
    public int hammingDistanceII(int x, int y) {
        // 异或运算符,两个数不相同，异或结果为1
        int xor = x ^ y;
        int res = 0;
        // 如果异或结果不为0
        // 先让两个数异或，然后数一数里面有多少个1；
        while (xor != 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }
}
