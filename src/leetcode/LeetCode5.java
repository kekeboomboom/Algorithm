package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len == 1) {
//            return s;
//        }
//        int maxLen = 1;
//        int begin = 0;
//
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//
//        return s.substring(begin, begin + maxLen);


        int len = s.length();

        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1> maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }
}
