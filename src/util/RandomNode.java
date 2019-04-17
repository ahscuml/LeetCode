package util;

/**
 * @author ahscuml
 * @date 2019/4/17
 * @time 21:40
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {}

    public RandomNode(int _val,RandomNode _next,RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
