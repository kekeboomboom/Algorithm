package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        List<Integer> res = new ArrayList<>();
        if(slen< plen) return res;
        int[] s_arr = new int[26];
        int[] p_arr = new int[26];
        for (int i = 0; i < plen; i++) {
            s_arr[s.charAt(i) - 'a']++;
            p_arr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s_arr, p_arr)) {
            res.add(0);
        }
        for (int i = plen; i < slen; i++) {
            s_arr[s.charAt(i) - 'a']++;
            s_arr[s.charAt(i - plen) - 'a']--;
            if (Arrays.equals(s_arr, p_arr)) {
                res.add(i - plen + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Arrays.equals(a, b);
    }
}
