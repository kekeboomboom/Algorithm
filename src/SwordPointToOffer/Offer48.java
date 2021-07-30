package SwordPointToOffer;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(chars[0], 0);
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(chars[i]) && i - dp[i - 1] <= map.get(chars[i])) {
                dp[i] = i - map.get(chars[i]);

            } else {
                dp[i] = dp[i-1] + 1;
            }
            map.put(chars[i], i);
        }
        int maxLen = 1;
        for (int i = 0; i < dp.length; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
}
