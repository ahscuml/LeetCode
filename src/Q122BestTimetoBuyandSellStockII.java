/**
 * @author ahscuml
 * @date 2019/1/23
 * @time 11:13
 */
public class Q122BestTimetoBuyandSellStockII {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 这个题就是个笑话哈哈哈，只要想明白了完全没有任何难度，只要将所有的正收益相加就可以
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            maxProfit += ((prices[i] - prices[i - 1]) > 0 ? prices[i] - prices[i - 1] : 0);
        }
        return maxProfit;
    }
}
