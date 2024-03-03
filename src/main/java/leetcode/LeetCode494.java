package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/5
 */
public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int res = 0;
        res += dfs(nums, target - nums[index], index + 1);
        res += dfs(nums, target + nums[index], index + 1);
        return res;
    }

    // 背包问题，感觉即使知道了思路，还有可能每次写的都不一样。
    public int findTargetSumWays2(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == Math.abs(target) ? 1 : 0;
        }
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        if ((sum + target) < 0) {
            return 0;
        }
        int bagCapacity = (sum + target) / 2;
        int[] dp = new int[bagCapacity + 1];
        dp[nums[0]]++;
        dp[0]++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = bagCapacity; j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]] + dp[j];
            }
        }
        return dp[bagCapacity];
    }


    // 这一版应该是最简洁的了。
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        if (sum < Math.abs(target)) {
            return 0;
        }
        int a = (sum + target) / 2;
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = a; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[a];
    }

}
