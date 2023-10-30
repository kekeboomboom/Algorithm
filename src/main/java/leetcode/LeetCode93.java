package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/17
 */
public class LeetCode93 {

    ArrayList<String> tmp = new ArrayList<>(4);
    LinkedList<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int index) {
        if (index == s.length()) {
            return;
        }
        if (tmp.size() == 3) {
            String lastIP = s.substring(index);
            if (checkIP(lastIP)) {
                tmp.add(lastIP);
                res.add(String.join(".", tmp));
                tmp.remove(tmp.size() - 1);
            }
            return;
        }
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (checkIP(substring)) {
                tmp.add(substring);
                backtracking(s,i+1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean checkIP(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length()>1) {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> strings = leetCode93.restoreIpAddresses("101023");

        System.out.println(strings.toString());
    }
}
