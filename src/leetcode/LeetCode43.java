package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/12
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        char[] res = new char[n1 + n2];
        Arrays.fill(res, '0');
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            char[] tmp = new char[n1 + n2];
            Arrays.fill(tmp, '0');
            // 先计算num1的第i位数和nums相乘的结果保存在tmp
            for (int j = n2 - 1; j >= 0; j--) {
                int nu1 = num1.charAt(i) - '0';
                int nu2 = num2.charAt(j) - '0';
                int sum = nu1 * nu2 + carry;
                carry = sum / 10;
                tmp[i + 1 + j] = (char) (sum % 10 + '0');
            }
            // 如果有多出来的进位没放到tmp中
            if (carry != 0) {
                tmp[i] = (char) (carry + '0');
                carry = 0;
            }
            // 将算出来的tmp加到最终结果中
            int jin = 0;
            for (int j = n1 + n2 - 1; j >= 0; j--) {
                int sum = res[j] - '0' + tmp[j] - '0' + jin;
                jin = sum / 10;
                res[j] = (char) (sum % 10 + '0');
            }

        }
        String ans = String.valueOf(res);
        // 将前几位的零剔除
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                ans = ans.substring(i);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        char a = 5 + '0';
//        System.out.println(a);
        String multiply = new LeetCode43().multiply("123", "456");
        System.out.println(multiply);
    }
}
