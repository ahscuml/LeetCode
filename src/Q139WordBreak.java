import java.util.*;

/**
 * wordDict中的单词能不能拼出来一个s
 *
 * @author ahscuml
 * @date 2019/1/2
 * @time 21:19
 */
public class Q139WordBreak {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));

        System.out.println(wordBreakIte(s, wordDict));
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * 双循环，利用判断条件
     */
    public static boolean wordBreakIte(String s, List<String> wordDict) {
        // dp[i]为true代表 s 从[0,i)满足要求
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 遍历这个字符串
        for (int i = 1; i <= s.length(); i++) {
            // 遍历字符词典
            for (String word : wordDict) {
                // i要比当前的字符长，并且在dp[i - word.length()]的地方要为true才代表从[0,i)满足要求
                // 并且word要与s.substring(i - word.length(), i) 相同
                if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 类似的思想，运行时间会更小一点
     * */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        }

        Set<String> set= new HashSet();
        int maxlen = 0;
        for(int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            set.add(word);
            maxlen = maxlen > word.length() ? maxlen : word.length();
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= maxlen; j++) {
                if(i - j >= 0 && dp[i - j] && set.contains(s.substring(i - j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
