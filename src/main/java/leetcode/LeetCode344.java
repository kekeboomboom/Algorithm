package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode344 {
    public void reverseString(char[] s) {
        if (s==null || s.length == 0) {
            return;
        }
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
        reverseHelper(s,start+1,end-1);

    }
}
