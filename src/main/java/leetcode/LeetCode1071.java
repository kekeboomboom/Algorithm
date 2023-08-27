package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/16
 */
public class LeetCode1071 {


    /**
     * 寻找两个字符串长度的最大公因数。如果这个最大公因数长度的子串能够拼接成str1和str2，那么就找到了最终结果。
     *
     * 问题：有没有一种可能，最大公因数长度的子串不能拼接str1 和 str2 ，但是其他较小的公因数长度的子串能够拼接成呢？
     * 如果存在一个较小的公因数能够拼接成str1和str2。有一个关系，最大公因数是一定可以被其他公因数整除的。因此一个较小的公因数长度的子串一定可以拼接成最大的公因数长度的子串
     * 而最大公因数都可以乘除str1和str2，因此较小公因数长度的子串能够拼接str1和str2的，那么最大公因数长度的子串也一定能。
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        int gcd = getGCD(str1.length(), str2.length());
        String substring = str1.substring(0, gcd);
        if (repeatString(substring, str1.length() / gcd).equals(str1) && repeatString(substring, str2.length() / gcd).equals(str2)) {
            return substring;
        }
        return "";
    }

    private String repeatString(String substring, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(substring);
        }
        return sb.toString();
    }

    private int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode1071 leetCode1071 = new LeetCode1071();
        String s = leetCode1071.gcdOfStrings("abcabcabc", "abc");
        System.out.println(s);

    }
}
