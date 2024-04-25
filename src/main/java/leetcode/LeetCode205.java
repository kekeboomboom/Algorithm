package leetcode;

import java.util.HashMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/24
 */
public class LeetCode205 {

    /**
     * 首先建立映射，map
     * 然后根据映射替换字符串中的字符，替换后看两个字符串是否想等
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
