package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/7
 */
public class LeetCode1143 {

    /**
     * dp[i][j] text1[0~i] text2[0~j] 公共最长子序列
     * 如果 text1[i] == text2[j] 则 dp[i][j] = dp[i-1][j-1]+1
     * 否则 dp[i][j] = max(dp[i-1][j] ,  dp[i][j-1])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                for (int j = i; j < text1.length(); j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < text2.length(); i++) {
            if (text2.charAt(i) == text1.charAt(0)) {
                for (int j = i; j < text2.length(); j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
