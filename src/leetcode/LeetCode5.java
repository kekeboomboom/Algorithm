package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode5 {

    //暴力破解
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > max) {
                    ans = test;
                    max = test.length();
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String test) {
        int len = test.length();
        for (int i = 0; i < len / 2; i++) {
            if (test.charAt(i) != test.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 中心扩散
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = aroundCenter(s, i, i);
            int len2 = aroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int aroundCenter(String s, int i, int j) {
        int L = i;
        int R = j;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    // 中心扩散
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int maxLen;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            int i1 = aroundCenter2(s, i, i);
            int i2 = aroundCenter2(s, i, i + 1);
            maxLen = Math.max(i1, i2);
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int aroundCenter2(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
