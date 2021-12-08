package leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        return canBreak(s, set, 0,memo);
    }

    private boolean canBreak(String s,HashSet<String>  wordDict, int start,int[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != 0) {
            return memo[start] == 1 ? true : false;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (wordDict.contains(substring) && canBreak(s, wordDict, i, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = -1;
        return false;
    }
}
