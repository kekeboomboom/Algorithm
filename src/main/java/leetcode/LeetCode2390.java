package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/6
 */
public class LeetCode2390 {

    /**
     * 这道题使用链表也可以，因为主要就是节点的删除
     *
     * 但是题目提示了，用栈，那么仔细想来，用栈确实更方便。
     * @param s
     * @return
     */
    public String removeStars(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode2390 leetCode2390 = new LeetCode2390();
        String s = leetCode2390.removeStars("leet**cod*e");

        System.out.println(s);
    }
}
