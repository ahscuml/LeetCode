/**
 * @author ahscuml
 * @date 2019/4/7
 * @time 0:04
 */
public class Q10RegularExpressionMatching {
    public static void main(String[] args) {
        // TODO 测试用例
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化，当模式串为0的时候，除了0,0为true，其余都为false
        dp[0][0] = true;
        // 当s为0的时候，如果模式串带有*还可能为空,保证前面一个不是*
        for(int j = 2; j <= p.length(); j++) {
            if(p.charAt(j - 1) == '*' && j > 1 && p.charAt(j - 2) != '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                // 首先确定如果相等的情况
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    // 匹配的情况
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 不匹配的情况，1. 真的不匹配，不用管，因为默认是false
                //  2. 出现'*'
                if(p.charAt(j - 1) == '*') {
                    if(s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        // 不匹配任何内容，那么x*只能为空
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // 2.1 x*不匹配任何内容，直接跳过
                        // 2.2 x*匹配一个内容
                        // 2.3 x*匹配很多个内容
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
