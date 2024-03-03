import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] prices = {7,1,5,3,6,4};
        main.maxProfit(prices);

    }


    /**
     * 我们使用dp来做，遇到股票买卖的问题，有一个统一的模板。
     * dp[i][0] 表示第i天持有股票所剩最大现金。
     * 第i-1天，没有持有 -nums[i]
     * 第i-1天，持有 dp[i-1][0]
     * 则 递推公式： dp[i][0] = max(-nums[i], dp[i-1][0])
     *
     * dp[i][1] 表示第i天不持有所剩最大现金
     * 第i-1天，没有持有  dp[i-1][1]
     * 第i-1天，持有  dp[i-1][0] + nums[i]
     * 则递推公式： dp[i][0] = max(dp[i-1][1], dp[i-1][] + nums[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        int result = Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        return Math.max(result, 0);
    }


}
