package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int minPrice;

        if (prices[0] > prices[1]) {
            dp[1] = 0;
            minPrice = prices[1];
        } else {
            dp[1] = prices[1] - prices[0];
            minPrice = prices[0];
        }
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[len-1];
    }
}
