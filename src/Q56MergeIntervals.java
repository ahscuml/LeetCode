import java.util.*;

/**
 * @author ahscuml
 * @date 2018/11/14
 * @time 16:57
 */
public class Q56MergeIntervals {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        List<Interval> test = new ArrayList<Interval>();
        test.add(new Interval(1, 3));
        test.add(new Interval(2, 6));
        test.add(new Interval(8, 10));
        test.add(new Interval(15, 18));
        for (Interval it : merge(test)) {
            System.out.print("[" + it.start + "," + it.end + "]");
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        // 主要思路就是给interval按照start的大小进行排序，排序完成之后再进行合并
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        // 进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        // 进行合并(inplace)
        ListIterator<Interval> iterator = intervals.listIterator();
        Interval cur = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (cur.end < next.start) {
                cur = next;
                continue;
            }
            cur.end = Math.max(cur.end, next.end);
            iterator.remove();
        }

        return intervals;
    }

    /**
     * Interval定义函数
     */
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
