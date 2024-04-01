package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/7
 */
public class LeetCode1035 {


    /**
     * 这题与字符串的最长公共子序列一样。
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 这里使用carl的trick，将dp长度+1，这样就不需要初始化了。
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
