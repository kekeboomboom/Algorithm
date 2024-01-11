package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/11
 * {@code @description:}
 */
public class LeetCode409 {

    /**
     * 排序，从左向右遍历。遍历当前字符，如果下一个字符与当前字符相同，则res+2。index调到下下个位置。
     * 如果下一个字符与当前不同，则index+1
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        char[] sortStr = s.toCharArray();
        Arrays.sort(sortStr);
        int res = 0;
        for (int i = 0; i < sortStr.length; i++) {
            if (i + 1 < sortStr.length && sortStr[i + 1] == sortStr[i]) {
                res += 2;
                i++;
            }
        }
        if (res < s.length()) {
            res++;
        }
        return res;
    }
}
