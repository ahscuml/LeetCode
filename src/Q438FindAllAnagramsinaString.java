import java.util.*;

/**
 * @author ahscuml
 * @date 2018/11/28
 * @time 20:44
 */
public class Q438FindAllAnagramsinaString {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagramsII(s, p));
    }

    /**
     * 滑动窗口 anagram
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        // A65-90 a97-122
        int[] hash = new int[123];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
            // 因为除了最开始，后面每一次都是right - left == p.length()
            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }

    /**
     * 利用HashMap,相对来说比较详细的方法 ， 也可以说是上面的方法的HashMap化
     * */
    public static List<Integer> findAnagramsII(String s, String t) {
        List<Integer> result = new LinkedList<>();

        if(t.length()> s.length()) {
            return result;
        }
        // 创建map存储t中产生过的字符
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // size是因为可能有重复的元素，需要知道map的大小
        int counter = map.size();
        // 前后两个类似指针
        int begin = 0, end = 0;

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            // 当counter为0的时候就代表begin-end中包含了t中所有的元素，需要查看end-begin == t.length
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                // 如果满足结果，添加条案
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }
}
