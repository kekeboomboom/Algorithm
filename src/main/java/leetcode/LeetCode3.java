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
        int i = -1;
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

    /**
     * 这题可以用动态规划，但是我觉得不好懂，用滑动窗口更简单易懂
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i))+1, left);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new LeetCode3().lengthOfLongestSubstring2("pwwkew");
        System.out.println(res);
    }
}
