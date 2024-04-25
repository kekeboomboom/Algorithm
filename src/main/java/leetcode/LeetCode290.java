package leetcode;

import java.util.HashMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/24
 */
public class LeetCode290 {


    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(split[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), split[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode290 leetCode290 = new LeetCode290();
        boolean b = leetCode290.wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }
}
