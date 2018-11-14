import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/11/14
 * @time 9:30
 */
public class Q49GroupAnagrams {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs1 = {};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs1));
    }

    /**
     * 目的就是找到用相同字母组合而成的字符串
     * 怎么区分使用了相同字母就是一个很关键的因素
     * 使用素数相乘(每个素数都代表一个字母)，但这样很容易越界
     * 另外一种给一个字符串中的字符排序，排序之后再比较
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String, List<String>> helper = new HashMap<>();
        for (String s : strs) {
            // 转换成字符数组的方法
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorts = String.valueOf(c);
            if (!helper.containsKey(sorts)) {
                helper.put(sorts, new ArrayList<>());
            }
            helper.get(sorts).add(s);
        }
        return new ArrayList<>(helper.values());
    }
}
