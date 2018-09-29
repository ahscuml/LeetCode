import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ahscuml
 * @date 2018/9/27
 * @time 9:45
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfSubstringUsingHashSet(str));
        System.out.println(lengthOfSubstringUsingHashMap(str));
    }

    /**
     * 利用字符串的一些操作，进行判断，时间复杂度O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int i = 0, length = 1;
        String sub = s.substring(0, 1);
        for (int j = 1; j < s.length(); j++) {
            if (sub.indexOf(s.substring(j, j + 1)) >= 0) {
                // i应该是s的下标
                i = sub.indexOf(s.substring(j, j + 1)) + i + 1;
                sub = s.substring(i, j + 1);
            } else {
                sub = s.substring(i, j + 1);
            }
            if (length - sub.length() < 0) {
                length = sub.length();
            }
        }
        return length;
    }

    /**
     * 利用HashSet，滑动窗口，没有重复j++，有重复i++,滑动一遍，找到最大的长度
     * ..........i.............j......
     * 还可以再优化，因为i++的过程中任然存在重复计算
     */
    public static int lengthOfSubstringUsingHashSet(String s) {
        int length = s.length(), ans = 0, i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i + 1);
            } else {
                set.remove(i++);
            }
        }
        return ans;
    }

    /**
     * 利用HashMap来进行查看 滑动窗口 时间复杂度O(n)
     * j是目前substring的起始点（不重复的），i是substring的终点，ans结果是i-j+1
     */
    public static int lengthOfSubstringUsingHashMap(String s) {
        int length = s.length(), ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0, j = 0; i < length; i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                j = Math.max(hashMap.get(s.charAt(i)), j);
            }
            ans = Math.max(ans, i - j + 1);
            // i是在string中的位置，在hashmap里是i+1，用来取j用
            hashMap.put(s.charAt(i), i + 1);
        }
        return ans;
    }
}
