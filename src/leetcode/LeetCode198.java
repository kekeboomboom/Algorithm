package leetcode;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        int res = Math.max(dp[1],dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = i-2; j >= 0; j--) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 时间复杂度更低的解法，只有o（n）
     * 对于当前的房子我们选择偷或者不偷，如果偷，dp[i-2]+nums[i]
     * 如果不偷，dp[i-1],在偷和不偷中选大的。
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }
        return dp[nums.length - 1];
    }
}
