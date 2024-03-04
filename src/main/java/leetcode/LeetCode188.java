package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/5
 */
public class LeetCode188 {

    /**
     * 这道题去看 leetcode123，如果123能够理解，那么此题只是将k做一次替换
     *
     *
     * 下面是leetcode123的思路
     *   * 看完题解，题解的意思对于最多买卖一次和无限次的，只分为持有和不持有，递推公式即可正确
     *      * 此题说最多买卖两次，那么状态就可以分为：
     *      * 0 ： 无任何操作
     *      * 1 ： 第一次持有
     *      * 2 ： 第一次不持有
     *      * 3 ： 第二次持有
     *      * 4 ： 第二次不持有
     *      *
     *      * 0 ： 无任何操作的，自然利润为0
     *      * 1 ： 无操作 或者 第一次持有，因此  dp[i-1][0] - price[i] 或者 dp[i-1][1]
     *      * 2 ： 第一次持有 或者 第一次不持有，dp[i-1][1] + price[i] 或者 dp[i-1][2]
     *      * 3 ： 第一次不持有 或者 第二次持有，dp[i-1][2] - price[i] 或者 dp[i-1][3]
     *      * 4 ： 第二次持有 或者 第二次不持有，dp[i-1][3] + price[i] 或者 dp[i-1][4]
     *
     *
     * 那么换成了k，
     * dp[i-1][2k-2] - price[i]     dp[i-1][2k-1]
     * dp[i-1][2k-1] + price[i]     dp[i-1][2k]
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][2*i-1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 2] - prices[i], dp[i - 1][2 * j - 1]);
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j - 1] + prices[i], dp[i - 1][2 * j]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

    public static void main(String[] args) {
        LeetCode188 leetCode188 = new LeetCode188();
        int[] prices = {2, 4, 1};
        int i = leetCode188.maxProfit(2, prices);
        System.out.println(i);

    }
}
