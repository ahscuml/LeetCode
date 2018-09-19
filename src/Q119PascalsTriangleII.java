import java.util.ArrayList;
import java.util.List;

/**
 * @author ahscuml
 * @date 2018/9/19
 * @time 22:33
 */
public class Q119PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(2));
    }

    /**
     * 主要利用list可以不固定长度的性质，不过要注意边界条件
     * */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return list;
        }

        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
