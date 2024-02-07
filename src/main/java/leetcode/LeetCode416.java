package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/5
 */
public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 背包问题从来不是直接给出的，需要我们进行分析的来。
     * 此问题让我们将数组一分为二，两部分还要相等。其实可以转化：求，从nums挑选一些元素，元素之和为整个数组之和的一半
     * 对于nums每个元素就是物品，元素值为物品重量和元素价值。在这题中，我认为物品重量和物品价值一一对应
     * 也就是说，物品重量为10，则物品价值也为10
     * 因此此题可以这样理解：sum为nums元素之和。我们有一个背包，容量为sum/2
     * nums每个元素的值为每个物品的重量及其价值，求这个背包能装的价值最大为多少？
     * 如果这个背包装的最大价值为nums/2，那么则返回true。
     * 否则返回false
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int bagCapacity = sum / 2;
        int maxValue = bagProblem(nums, bagCapacity);
        if (maxValue == bagCapacity) {
            return true;
        }
        return false;
    }

    private int bagProblem(int[] nums, int bagCapacity) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[bagCapacity+1];
        for (int i = nums[0]; i <= bagCapacity; i++) {
            dp[i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = bagCapacity; j >=nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 如果找到了背包价值能凑成 bagCapacity的，直接剪枝
            if (dp[bagCapacity] == bagCapacity) {
                return bagCapacity;
            }
        }
        return dp[bagCapacity];
    }
}
