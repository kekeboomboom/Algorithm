package other.exam.meituan;

import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/8/22
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int opt = sc.nextInt();
            if (opt == 1) {
                sb.append(sc.next());
            } else {
                int index = sc.nextInt() -1;
                System.out.println(findNear(sb, index));
            }
        }
//        System.out.println(sb.toString());
    }

    private static int findNear(StringBuilder sb, int index) {
        char[] chars = sb.toString().toCharArray();
        int left = index-1,right=index+1;
        while (left > 0 && chars[left] != chars[index]) {
            left--;
        }
        while (right < chars.length-1 && chars[right] != chars[index]) {
            right++;
        }
        if (chars[right] != chars[index] && chars[left] != chars[index]) {
            return -1;
        } else if (chars[right] == chars[index] && chars[left] != chars[index]) {
            return right - index;
        } else if (chars[right] != chars[index] && chars[left] == chars[index]) {
            return index - left;
        } else {
            return Math.min(right - index, index - left);
        }
    }
}
