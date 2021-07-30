package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class LeetCode32 {

    public int longestValidParentheses(String s) {
        int len = 0;
        int max = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && s.charAt(i) == ')') {
                len = 0;
            }
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
                len += 2;
                max = Math.max(max, len);
            }
            if (s.charAt(i) == '(') {
                stack.push('(');
            }
        }
        return max;
    }
}
