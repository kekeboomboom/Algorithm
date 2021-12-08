package other.exam.NETEASE;

import java.util.LinkedHashMap;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution2 {

    // si = si-1 + li + reverse(invert(si-1))
    public char findKthBit(int n, int k) {
        String[] dp = new String[n + 1];
        dp[1] = "a";
        for (int i = 2; i <= n; i++) {
            char Li = (char) ('a' + i - 1);
            dp[i] = dp[i - 1] + Li + reverse(invert(dp[i - 1]));
        }
        return dp[n].charAt(k-1);
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char res = (char) ('z' - (c - 'a'));
            sb.append(res);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        char res = 'z' - ('c' - 'a');
//        System.out.println(res);
        Solution2 s2 = new Solution2();
//        String abz = s2.invert("abz");
//        System.out.println(abz);
//        System.out.println(s2.reverse("abc"));
//        char Li = (char) ('a' + 2);
//        System.out.println(Li);
        char res = s2.findKthBit(4, 11);
        System.out.println(res);
    }
}
