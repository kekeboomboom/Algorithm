package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/13
 * {@code @description:}
 */
public class LeetCode583 {

    /**
     * 要删除几个，那么题意转换过来就是，两个word的最大公共子序列长度是多少。
     * 如果两个word的最大公共子序列长度为x，那么则需要删除 (word1.length + word2.length) - 2 * x
     * dp[i][j] word1[0~i] word2[0~j] 最大公共子序列长度
     * if word1[i] == word2[j] : dp[i][j] = dp[i-1][j-1] + 1
     * else : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            if (i>0&&dp[i-1][0] == 1) {
                dp[i][0] = 1;
                continue;
            }
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            if (i > 0 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
                continue;
            }
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (word1.length() + word2.length()) - 2 * dp[word1.length() - 1][word2.length() - 1];
    }
}
