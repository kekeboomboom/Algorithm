package other.exam.baidu;

import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/9/7
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String n = sc.next();
            System.out.println(smallN(n));
        }
    }

    private static String smallN(String strn) {
        StringBuilder sb = new StringBuilder();
        if (strn.charAt(0) == '1' && strn.charAt(1) == '0') {
            for (int i = 0; i < strn.length() - 1; i++) {
                sb.append("3");
            }
            return sb.toString();
        }
        for (int i = 0; i < strn.length(); i++) {
            if (strn.charAt(i) > '3') {
                sb.append("3");
            } else if (strn.charAt(i) == '0') {
                if (strn.charAt(i - 1) == '1') {
                    sb.replace(i - 1, i, "0");
                } else if (strn.charAt(i - 1) == '2') {
                    sb.replace(i - 1, i, "1");
                } else {
                    sb.replace(i - 1, i, "2");
                }
                for (int j = i; j < strn.length(); j++) {
                    sb.append("3");
                }
                return sb.toString();
            } else {
                sb.append(strn.charAt(i));
            }
        }
        return sb.toString();
    }
}
