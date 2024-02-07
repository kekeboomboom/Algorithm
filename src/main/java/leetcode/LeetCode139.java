package leetcode;

import java.util.HashMap;
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


    /**
     * 我们先用回溯暴力做。
     * 每次回溯：查询当前dict是否有可以消除s的，如果有则消除。
     * 需要进行剪枝，有dict：["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     * 其中使用两次aa和一次aaaa是一样的，因此可以剪枝。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return bfs(s, wordDict, map);
    }

    private boolean bfs(String s, List<String> wordDict, HashMap<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (String word : wordDict) {
            if (s.length() < word.length()) {
                continue;
            }
            if (s.substring(0, word.length()).equals(word)) {
                boolean res= bfs(s.substring(word.length()), wordDict,map);
                if (res) {
                    return res;
                }
                map.put(s.substring(word.length()), res);
            }
        }
        return false;
    }
}
