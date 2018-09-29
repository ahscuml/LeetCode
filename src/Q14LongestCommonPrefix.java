/**
 * 14. Longest Common Prefix
 * @author ahscuml
 * @date 2018/9/26
 * @time 16:06
 */
public class Q14LongestCommonPrefix {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        String[] strs = {"abA","abb","abc"};
        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * 我觉得就是考验对于String的操作，一些方法的使用
     * */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }
            i++;
        }
        return prefix;
        
    }
}
