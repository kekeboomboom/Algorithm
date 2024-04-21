import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 3, 1, 1, 4};



    }


    /**
     * 之前到看一种解法，先是反转整个字符串，然后再反转每个单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String reverseStr = reverseStr(s.trim());

        String[] split = reverseStr.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : split) {
            if (str.trim().isEmpty()) {
                continue;
            }
            result.append(reverseStr(str) + " ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private String reverseStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
