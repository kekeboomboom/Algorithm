package leetcode;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] > minPrice && prices[i] < prices[i - 1]) {
                res += prices[i-1] - minPrice;
                minPrice = prices[i];
            } else if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return 1;
    }
}
