package TEST;

/**
 * @author ahscuml
 * @date 2018/11/19
 * @time 8:50
 */
public class BigNumber {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        System.out.println(bigNumberSum("923485098340958023", "9823457932475932875923"));
        System.out.println(bigNumberSum("10", "90"));
    }

    /**
     * 两个大数，用String类型存储
     * 转换为char数组类型，低位在前，然后对于数组进行运算
     */
    private static String bigNumberSum(String bigNumberA, String bigNumberB) {
        // 将两个大数进行逆序存储
        char[] charsA = new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charsB = new StringBuffer(bigNumberB).reverse().toString().toCharArray();
        // 构建result数组，长度为大数最大长度加一
        int maxLength = charsA.length > charsB.length ? charsA.length : charsB.length;
        int[] result = new int[maxLength + 1];
        // 遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            if (i < charsA.length) {
                temp += charsA[i] - '0';
            }
            if (i < charsB.length) {
                temp += charsB[i] - '0';
            }
            // 判断是否进位
            if (temp > 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        // 将result逆序并且转换为String
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; i--) {
            // 去除result开头的0,只判断第一位是否是0
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
