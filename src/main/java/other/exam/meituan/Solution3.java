package other.exam.meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/8/22
 */
public class Solution3 {

    static int index = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int res = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        while (index < chars.length) {
            res *= cal(stack, chars, 1);
        }
        System.out.println(res % 1000000007);
    }

    private static int cal(LinkedList<Integer> stack, char[] chars, int tmp) {
        stack.push(index);
        index++;
        while (!stack.isEmpty()) {
            if (chars[index] == '(') {
                stack.push(index);
            } else {
                Integer pop = stack.pop();
                if (pop == index - 1) {
                    tmp *= 2;
                } else {
                    tmp += 1;
                }
            }
            index++;
        }
        return tmp;
    }
}
