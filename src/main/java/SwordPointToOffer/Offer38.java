package SwordPointToOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer38 {

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new LinkedList<>();
        StringBuilder tmp = new StringBuilder();
        boolean[] used = new boolean[chars.length];

        process(chars, chars.length, 0, tmp, res, used);
        String[] result = new String[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void process(char[] chars, int len, int depth, StringBuilder tmp, List<String> res, boolean[] used) {
        if (depth == len) {
            res.add(new String(tmp));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            if (!used[i]) {
                set.add(chars[i]);
                tmp.append(chars[i]);
                used[i] = true;
                process(chars, len, depth + 1, tmp, res, used);
                used[i] = false;
                tmp.deleteCharAt(tmp.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        StringBuilder tmp2 = new StringBuilder("abc");
        tmp2.deleteCharAt(tmp2.length() - 1);
        System.out.println(tmp2);
    }
}
