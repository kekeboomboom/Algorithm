package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/21
 */
public class LeetCode151 {

    /**
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        LinkedList<String> arr = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (word.length() > 0) {
                    arr.add(word.toString());
                    word.delete(0, word.length());
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        if (word.length() > 0) {
            arr.add(word.toString());
        }
        Collections.reverse(arr);
        return arr.stream().collect(Collectors.joining(" "));

    }

    public static void main(String[] args) {
        LeetCode151 leetCode151 = new LeetCode151();
        String s = leetCode151.reverseWords("a good   example");
        System.out.println(s);


    }
}
