package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/21
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (checkYuan(chars[left])) {
                while (!checkYuan(chars[right])) {
                    right--;
                }
                reverseChar(chars, left, right);
                right--;
            }
            left++;
        }
        return String.valueOf(chars);
    }

    private void reverseChar(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    private boolean checkYuan(char aChar) {
        if (aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u' || aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode345 leetCode345 = new LeetCode345();

        String hello = leetCode345.reverseVowels("leetcode");
        System.out.println(hello);
    }
}
