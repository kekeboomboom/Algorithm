package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/27
 */
public class LeetCode71 {

    /**
     * 1. 如果是 / 是结尾的，那么不需要加
     * 2. 只要遇到两个. 则将前面都清楚，如果遇到一个. 那么就什么都不做
     * 3. 如果栈顶是 / ，再遇到/ 就不用添加
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (stack.isEmpty()) {
                    stack.push(path.charAt(i));
                } else {
                    if (i == path.length() - 1 || stack.peek() == '/') {
                        continue;
                    } else {
                        stack.push(path.charAt(i));
                    }
                }
            } else if (path.charAt(i) == '.' && path.charAt(i + 1) == '.') {
                i++;
                stack.clear();
            } else if (path.charAt(i) == '.') {
                continue;
            } else {
                stack.push(path.charAt(i));
            }
        }
        if (!stack.isEmpty() && stack.peek() == '/' && stack.size() > 1) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode71 leetCode71 = new LeetCode71();
        String s = leetCode71.simplifyPath("/a/../../b/../c//.//");
        System.out.println(s);
    }
}
