package leetcode;

/**
 * @author keboom
 * @date 2021/8/23
 */
public class LeetCode377 {

    // 本以为是回溯，没想到是动态规划，背包问题，其实想象也对，他只让求有几种，没让列举所有
    /**
     * 背包问题
     * https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 懂了这个dp思路，这就跟跳台阶一样，当前n的方法数，等于n-1的方法数加上n-2的方法数
        // 跳台阶是固定的一步或者两步，只不过这个是num步
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        int res = new LeetCode377().combinationSum4(nums, 4);
        System.out.println(res);
    }

}
