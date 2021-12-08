package leetcode;

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
        res += dfs(nums, target - nums[index], index+1);
        res += dfs(nums, target + nums[index], index+1);
        return res;
    }
}
