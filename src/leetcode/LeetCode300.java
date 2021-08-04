package leetcode;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode300 {

    /**
     * o(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 参考《程序员代码面试指南》
     * 我们维护一个ends
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int[] ends = new int[nums.length];
        dp[0] = 1;
        ends[0] = nums[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (nums[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m -1;
                }
            }
            right = Math.max(right, l);
            ends[l] = nums[i];
            dp[i] = l + 1;
        }
        return right + 1;
    }
}
