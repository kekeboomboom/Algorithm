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
        int[] prices = {1,2,3,0,2};
        main.maxProfit(prices);


    }

    /**
     * 加一个冷冻期，无非多加一种状态
     * dp[i][0] 当前状态为持有股票所剩现金
     * i-1天不持有 dp[i-1][1] - price[i]
     * i-1天持有   dp[i-1][0]
     * i-1天冷冻  dp[i-1][2] - price[i]
     *
     * dp[i][1] 当前状态为不持有所剩最大现金
     * 前一天不持有  dp[i-1][1]
     * 前一天持有    dp[i-1][0] + price[i]
     * 前一天冷冻    dp[i-1][2]
     *
     * dp[i][2] 当前冷冻期
     * 前一天不持有 dp[i-1][1]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]), dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]), dp[i - 1][2]);
            dp[i][2] = dp[i - 1][1];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
