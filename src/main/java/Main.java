import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean leetcode = main.wordBreak("applepenapple", wordDict);
        System.out.println(leetcode);

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
    public boolean wordBreak(String s, List<String> wordDict) {
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
