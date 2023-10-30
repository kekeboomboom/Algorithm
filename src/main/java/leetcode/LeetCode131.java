package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/16
 */
public class LeetCode131 {

    ArrayList<String> tmp = new ArrayList<>();
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (checkPalindrome(substring)) {
                tmp.add(substring);
                backtracking(s, i+1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> aab = leetCode131.partition("aab");
        System.out.println(aab.toString());
    }
}
