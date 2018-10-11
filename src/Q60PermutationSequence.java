import java.util.ArrayList;

/**
 * @author ahscuml
 * @date 2018/10/10
 * @time 22:09
 */
public class Q60PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n,k));
    }
    // 主要思路还是找规律
    // 通过K，和元素个数可以确定第一个元素的大小，逐次寻找，直到找到最后一个
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        // n！是总的可能数。
        // (n-1)!是首字母是同一个数字的个数
        // (k-1)/(n-1)! 是在index中的位置(k-1是为了避免当3/3本身的index是0这种情况)
        for (int i = 0, l = k - 1; i < n; i++) {
            // 可能出现的组合个数
            fact /= (n - i);
            // 数组元素的下标(注意这个从0开始)
            int index = (l / fact);
            // 从数组中移除元素同时加到字符串中
            sb.append(num.remove(index));
            // 减去之前计算过的次数(也就是之前分别计算过的K)
            l -= index * fact;
        }
        return sb.toString();
    }
}
