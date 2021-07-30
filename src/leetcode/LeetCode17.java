package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        String[] letter_map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        process(digits, sb, res, 0,letter_map);
        return res;
    }

    private void process(String digits, StringBuilder sb, List<String> res, int index,String[] map) {
        if (index == digits.length()) {
            res.add(new String(sb));
            return;
        }
        String s = map[digits.charAt(index)-'0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            process(digits, sb, res, index+1, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
