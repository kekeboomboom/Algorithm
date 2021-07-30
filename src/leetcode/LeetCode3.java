package leetcode;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/3/6
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i =-1;
        int res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

}
