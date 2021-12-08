package leetcode;

/**
 * @author keboom
 * @date 2021/2/23
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;


    }
}
