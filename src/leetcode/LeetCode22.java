package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        process(2 * n, 0, res, tmp, stack);
        return res;
    }

    private void process(int len, int index, List<String> res, StringBuilder tmp, LinkedList<Character> stack) {
        if (index == len) {
            res.add(new String(tmp));
            return;
        }
        if (stack.size() < len - index) {
            tmp.append('(');
            stack.push(')');
            process(len, index + 1, res, tmp, stack);
            tmp.deleteCharAt(tmp.length() - 1);
            stack.pop();
        }
        if (!stack.isEmpty()) {
            tmp.append(')');
            stack.pop();
            process(len, index + 1, res, tmp, stack);
            tmp.deleteCharAt(tmp.length() - 1);
            stack.push(')');
        }
    }
}
