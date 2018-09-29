/**
 * @author ahscuml
 * @date 2018/9/27
 * @time 15:46
 */
public class Q5LongestPalindromicSubstring {
    /**
     *
     * */
    public static void main(String[] args) {
        String s = "abacdfabcdcba";
        System.out.println(longestPalindrome(s));
    }
    /**
     *
     * */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int start = 0,end = 0,i = 0,j = 0;
        String longestSub  = "";
        for(int p = 0;p<length;p++) {
            // abba这种形式
            i = p - 1 ;
            j = p ;
            while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if(j - i -2 > end - start) {
                start = i+1;
                end = j-1 ;
            }
            // ababa这种形式
            i = p;
            j = p;
            while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if(j - i - 2 > end - start) {
                start = i +1;
                end = j - 1;
            }
        }
        longestSub = s.substring(start,end + 1);
        return longestSub;
    }
}
