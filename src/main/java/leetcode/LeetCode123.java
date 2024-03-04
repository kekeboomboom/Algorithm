package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/5
 */
public class LeetCode123 {

    /**
     * 看完题解，题解的意思对于最多买卖一次和无限次的，只分为持有和不持有，递推公式即可正确
     * 此题说最多买卖两次，那么状态就可以分为：
     * 0 ： 无任何操作
     * 1 ： 第一次持有
     * 2 ： 第一次不持有
     * 3 ： 第二次持有
     * 4 ： 第二次不持有
     *
     * 0 ： 无任何操作的，自然利润为0
     * 1 ： 无操作 或者 第一次持有，因此 -price[i] 或者 dp[i-1][1]
     * 2 ： 第一次持有 或者 第一次不持有，dp[i-1][1] + price[i] 或者 dp[i-1][2]
     * 3 ： 第一次不持有 或者 第二次持有，dp[i-1][2] - price[i] 或者 dp[i-1][3]
     * 4 ： 第二次持有 或者 第二次不持有，dp[i-1][3] + price[i] 或者 dp[i-1][4]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[prices.length - 1][4];
    }

    public static void main(String[] args) {
        LeetCode123 leetCode123 = new LeetCode123();
        int[] prices = {7, 6, 4, 3, 1};
        int i = leetCode123.maxProfit(prices);

    }
}
