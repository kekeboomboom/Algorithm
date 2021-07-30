package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/2/23
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(')');
            } else if (c == '[') {
                stack.addLast(']');
            } else if (c == '{') {
                stack.addLast('}');
            } else if (stack.isEmpty() || c != stack.removeLast()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
