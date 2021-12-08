package leetcode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode394 {

    public String decodeString(String s) {
        Deque<Integer> num_stack = new LinkedList<>();
        Deque<String> str_stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.valueOf(c - '0');
            } else if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else if (c == '[') {
                num_stack.addFirst(multi);
                str_stack.addFirst(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else {
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < num_stack.removeFirst(); i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(str_stack.removeFirst() + tmp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        char a = '1';
//        System.out.println(Integer.valueOf(a + ""));
        LinkedList<Integer> stack = new LinkedList<>();
        Integer integer = stack.removeLast();
        System.out.println(integer);
    }
}
