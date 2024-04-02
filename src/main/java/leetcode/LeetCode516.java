package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/14
 * {@code @description:}
 */
public class LeetCode516 {

    /**
     * dp[i][j] 表示从i到j，最从会问子序列长度
     * for i = 1 ; i < s.len ; i++
     *     for j = i ; j >= 0 ; j--
     *          if s[i] == s[j]
     *              dp[i][j] = dp[i-1][j+1] + 2
     *          else
     *              dp[i][j] = dp[i-1][j]
     * @param s
     * @return
     */
//    public int longestPalindromeSubseq(String s) {
//
//    }
}
