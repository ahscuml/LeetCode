import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author ahscuml
 * @date 2018/9/14
 * @time 19:47
 */
public class Q22GenerateParentheses {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        String cur = "";
        backTrack(list, cur, n, 0, 0);
        return list;
    }

    // 自己的思路 想起来倒是很简单，但是看起来很复杂
    public static void backTracking(List<String> list, String cur, int n, int leftcount, int rightcount) {
        if (leftcount == n && rightcount == n) {
            list.add(cur);
        } else if (leftcount > n || rightcount > n || leftcount < rightcount) {
            return;
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    cur = cur.concat("(");
                    leftcount++;
                } else {
                    cur = cur.concat(")");
                    rightcount++;
                }
                backTracking(list, cur, n, leftcount, rightcount);
                if (cur.charAt(cur.length() - 1) == '(') {
                    leftcount--;
                } else {
                    rightcount--;
                }
                cur = cur.substring(0, cur.length() - 1);
            }
        }
    }

    // 别人的思路
    public static void backTrack(List<String> list, String cur, int n, int leftcount, int rightcount) {
        if (cur.length() == n * 2) {
            list.add(cur);
            return;
        }
        if (leftcount < n) {
            backTrack(list, cur + "(", n, leftcount + 1, rightcount);
        }
        if (rightcount < leftcount) {
            backTrack(list, cur + ")", n, leftcount, rightcount + 1);
        }
    }
}
