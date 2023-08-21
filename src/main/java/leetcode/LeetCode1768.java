package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/16
 */
public class LeetCode1768 {

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len1 || i < len2) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1768 test = new LeetCode1768();
//        String s = test.mergeAlternately("abc", "pqr");
//        String s = test.mergeAlternately("abcde", "pqr");
        String s = test.mergeAlternately("abc", "pqrst");


        System.out.println(s);

    }
}
