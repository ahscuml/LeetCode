/**
 * @author ahscuml
 * @date 2018/11/20
 * @time 16:48
 */
public class Q771JewelsandStones {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {

    }

    /**
     * 没明白为什么这么多人赞
     * */
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] charJ = J.toCharArray();
        char[] charS = S.toCharArray();
        for (char j : charJ) {
            for (char s: charS) {
                if (j == s) {
                    count++;
                }
            }
        }
        return count;
    }
}
