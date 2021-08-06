package leetcode;

/**
 * @author keboom
 * @date 2021/8/5
 */
public class LeetCode647 {

    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            res++;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] > 0)){
                    dp[i][j] = j - i + 1;
                    res++;
                }
            }
        }
        return res;
    }
}
