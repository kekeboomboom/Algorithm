package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/7
 */
public class LeetCode718 {

    /**
     * dp[i][j] num1[i] nums2[j] 结尾的子数组中，公共最长子数组长度
     * dp[i][j] 如果nums[i] == nums[j] 则 dp[i][j] = dp[i-1][j-1] + 1
     * 否则 dp[i][j] = 0
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int maxlen = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                maxlen=1;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
                maxlen = 1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        return maxlen;
    }
}
