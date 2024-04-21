package leetcode;

import java.util.HashMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/19
 */
public class LeetCode12 {

    /**
     * 这道题目的数字大小是有限的，而且不多，最多到千位上。
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // 我们从数字的最小位开始吧。
        int numSize = 1;
        while (num > 0) {
            int number = (num % 10) * numSize;
            num /= 10;
            numSize *= 10;
            if (number == 1) {
                sb.insert(0, "I");
            } else if (number == 5) {
                sb.insert(0, "V");
            } else if (number == 10) {
                sb.insert(0, "X");
            } else if (number == 50) {
                sb.insert(0, "L");
            } else if (number == 100) {
                sb.insert(0, "C");
            } else if (number == 500) {
                sb.insert(0, "D");
            } else if (number == 1000) {
                sb.insert(0, "M");
            } else if (number == 4) {
                sb.insert(0, "IV");
            } else if (number == 9) {
                sb.insert(0, "IX");
            } else if (number == 40) {
                sb.insert(0, "XL");
            } else if (number == 90) {
                sb.insert(0, "XC");
            } else if (number == 400) {
                sb.insert(0, "CD");
            } else if (number == 900) {
                sb.insert(0, "CM");
            } else if (number > 1 && number < 9) {
                if (number < 4) {
                    sb.insert(0, repeat("I", number));
                } else {
                    sb.insert(0, repeat("I", number - 5));
                    sb.insert(0, "V");
                }
            } else if (number > 10 && number < 90) {
                if (number < 40) {
                    sb.insert(0, repeat("X", number/10));
                } else {
                    sb.insert(0, repeat("X", (number / 10) - 5));
                    sb.insert(0, "L");
                }
            } else if (number > 100 && number < 900) {
                if (number < 400) {
                    sb.insert(0, repeat("C", number / 100));
                } else {
                    sb.insert(0, repeat("C", number / 100 - 5));
                    sb.insert(0, "D");
                }
            } else if (number > 1000) {
                sb.insert(0, repeat("M", number / 1000));
            }
        }

        return sb.toString();
    }

    private String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
        String s = leetCode12.intToRoman(1894);

        System.out.println(s);
    }
}
