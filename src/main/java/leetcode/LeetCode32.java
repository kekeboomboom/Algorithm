package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class LeetCode32 {

    public int longestValidParentheses(String s) {
        char[] sc = s.toCharArray();
        int[] dp = new int[sc.length];
        int maxLen = 0;
        for (int i = 1; i < sc.length; i++) {
            if (sc[i] == ')') {
                if (sc[i - 1] == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i-2];
                    }
                } else if (dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 1 >= 0 && sc[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i-1]+2;
                        if (i - dp[i - 1] - 2 >= 0 && dp[i - dp[i - 1] - 2] > 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
