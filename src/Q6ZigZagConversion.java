/**
 * @author ahscuml
 * @date 2018/11/26
 * @time 11:24
 */
public class Q6ZigZagConversion {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Q6ZigZagConversion test = new Q6ZigZagConversion();
        System.out.println(test.convert(s, numRows));
    }

    /**
     *  找规律的一道问题，另外还要注意numRows == 1这个条件的判断
     * */
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        // 找到规律，分层来实现这个事情
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numRows; i++) {
            int front = (numRows - i) * 2;
            int beh = (numRows - 1) * 2 - front;
            int cur = i - 1;
            boolean odd = false;
            if(front == 0) {
                odd = true;
            }
            while(cur < length) {
                if( odd == false) {
                    sb.append(s.charAt(cur));
                    cur+=front;
                    if(beh != 0) {
                        odd = true;
                    }
                } else {
                    sb.append(s.charAt(cur));
                    cur+=beh;
                    if(front != 0) {
                        odd = false;
                    }
                }
            }
        }
        return sb.toString();
    }
}
