import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/9/28
 * @time 9:22
 */
public class Q17LetterCombinationsofaPhoneNumber {
    /**
     * 将键盘存储在一个数组中
     */
    private static final String[] letter = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        String digits = "256";
        System.out.println(letterCombinations(digits));
    }

    /**
     * 主要利用递归的思想
     * 问题的发展是一个树形的结构
     * 遍历完一个结果之后再遍历另一个结果，由尾巴到顶点
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        findCombinations(digits, 0, res, "");
        return res;
    }

    /**
     * @param digits 数字字符串.
     * @param index  当前计算的下标
     * @param res    返回的结果
     * @param tem    存储用的数组
     */
    private static void findCombinations(String digits, int index, ArrayList<String> res, String tem) {
        // 如果长度已经到达叶子节点，就将结果存储起来，并返回
        if (index == digits.length()) {
            res.add(tem);
            return;
        }
        // 如果没有到达叶子节点，添加当前数字对应的字母到字符串中，然后继续寻找下一个
        int num = (int) digits.toCharArray()[index] - (int) '0';
        for (int i = 0; i < letter[num].length(); i++) {
            findCombinations(digits, index + 1, res, tem + letter[num].charAt(i));
        }
    }
}
