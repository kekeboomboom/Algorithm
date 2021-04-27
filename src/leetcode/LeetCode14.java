package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/3/5
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        Arrays.sort(strs);
        StringBuilder maxStr = new StringBuilder();
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        for (int i = 0; i < first.length; i++) {
            if (first[i] == last[i]) {
                maxStr.append(first[i]);
            } else {
                break;
            }
        }
        return maxStr.toString();
    }
}
