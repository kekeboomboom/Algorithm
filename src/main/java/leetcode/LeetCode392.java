package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/27
 */
public class LeetCode392 {

    /**
     * 很容易想到双指针，一个指针指向s，一个指针指向t。如果s中字符与t中字符相等，那么s中指针向下移动，直到s指针只到超出索引。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            indexT++;
        }
        if (indexS >= s.length()) {
            return true;
        }
        return false;
    }
}
