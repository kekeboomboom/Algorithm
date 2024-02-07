package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/8/5
 */
public class LeetCode494 {


    HashMap<String, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        if (map.containsKey(target + "," + index)) {
            return map.get(target + "," + index);
        }
        int res = 0;
        res += dfs(nums, target - nums[index], index + 1);
        res += dfs(nums, target + nums[index], index + 1);
        map.put(target + "," + index, res);
        return res;
    }


    public static void main(String[] args) {
        LeetCode494 leetCode494 = new LeetCode494();
        int[] nums = {1, 1, 1, 1, 1};
        int targetSumWays2 = leetCode494.findTargetSumWays(nums, 3);
        System.out.println(targetSumWays2);
    }

    /**
     * 这个题目求的不是背包能装的最大的价值
     * 假如 a -b=target  a + b = sum
     * then  2a = target + sum
     * 那么可以转换成，如何挑选物品，能使物品总量和为（target+sum)/2，求有几种可能的方案
     * 题意转化：我们从数组中挑选几个和为a的，求有几种可能的挑选方案
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        // 如果我们用01背包，那么dp的含义会有变化。
        // dp[i]含义为当凑成数字之和为 i 时，总共有dp[i]条方法
        // 递推公式：dp[i] = dp[i] + dp[i-nums[curIndex]]
        // 初始化：dp[0]=1
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        if ((sum + target)<0) {
            return 0;
        }
        int a = (target + sum) / 2;
        if (a < 0) {
            a = -a;
        }
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = a; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[a];
    }

}
