package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/13
 * {@code @description:}
 */
public class LeetCode72 {

    /**
     * 将word1改造，最少需要几步到word2
     * 那么我们一下子不知道该如何改造，但是我们先从word1[0] word2[0]找规律
     * if word1[0] == word2[0] : 则不需要改造
     * else : 需要一步改造
     * 针对 word1: horse word2: ros
     * 1    2   2   3   4
     * 2    1  1+1 2+1 3+1
     * 3    -- -- --- --- --
     * 找出规律:
     * dp[i][j] word1[0~i] word2[0~j] 最少需要的步数
     * if word1[i] == word2[j] : dp[i][j] = dp[i-1][j-1]
     * else: dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length()][word2.length()];
        if (word1.charAt(0) != word2.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < word2.length(); i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length() - 1][word2.length() - 1];
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        int i = leetCode72.minDistance("horse", "ros");
        System.out.println(i);
    }
}
