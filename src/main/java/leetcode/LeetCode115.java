package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/11
 * {@code @description:}
 */
public class LeetCode115 {

    /**
     * 我无法一下知道整个t在s中子序列出现的个数，但是我可以从最短的开始。
     * dp[i][j] s[i-1]结尾 t[j-1]结尾 子序列个数
     *
     * dp[0][0] 为 s 和 t 都为空字符串时子序列个数
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
