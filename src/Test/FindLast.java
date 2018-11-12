package Test;

/**
 * 标号1-n的n个人首尾相接，1到3报数，报到3的推出，求最后一个人的标号
 *
 * @author ahscuml
 * @date 2018/10/25
 * @time 17:19
 */
public class FindLast {
    public static void main(String[] args) {
        System.out.println("留下的元素是:  " + FindLast(8));
    }

    private static int FindLast(int n) {
        // 1标号从0开始到n, 存放到一个长度为n的数组中
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        // 每次删除一个人就将这个人在数组中的数字置为0同时count++
        int count = 0;
        // 辅助数组，记录当前元素是否是3，如果是3就删除
        int aux = 0;
        // 辅助元素，记录数组的下标
        int i = 0;
        while (count < n - 1) {
            // 收尾相连
            if (i >= n) {
                i = i - n;
            }
            if (nums[i] != 0) {
                aux++;
                if (aux == 3) {
                    System.out.println("被删的元素是： " + nums[i]);
                    aux = 0;
                    nums[i] = 0;
                    count++;

                }

            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                return nums[j];
            }
        }
        throw new RuntimeException("!!1");
    }
}
