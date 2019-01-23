/**
 * @author ahscuml
 * @date 2019/1/23
 * @time 10:49
 */
public class Q121BestTimetoBuyandSellStock {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitII(prices));
    }

    /**
     * 动态规划方法，利用LeetCode第53题最大子序列问题的解决方法解决这个问题
     * */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // 将差值存储为一个序列，然后问题转化为第53题，求最长子序列问题(最大的差值)
        int[] dp = new int[n - 1];
        for(int i = 1; i < n; i++) {
            dp[i - 1] = prices[i] - prices[i - 1];
        }
        int maxProfit = 0, maxProfitEnd = 0;
        for(int i = 0; i < n - 1; i++) {
            maxProfitEnd =  dp[i] + (maxProfitEnd > 0 ? maxProfitEnd : 0);
            maxProfit = Math.max(maxProfit, maxProfitEnd);
        }
        return maxProfit;
    }

    /**
     * kadane算法
     * 相当于上面方法的简化，节约了空间
     * */
    public static int maxProfitII(int[] prices) {
        // 判断输入是否合适
        if(prices.length < 2 || prices == null) {
            return 0;
        }
        int maxProfit = 0, maxProfitPre = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfitPre += (prices[i] - prices[i - 1]);
            if (maxProfitPre > maxProfit) {
                maxProfit = maxProfitPre;
            }
            if (maxProfitPre < 0) {
                maxProfitPre = 0;
            }
        }
        return maxProfit;
    }
}
