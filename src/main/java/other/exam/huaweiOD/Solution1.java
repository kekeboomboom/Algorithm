package other.exam.huaweiOD;

import java.util.Scanner;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/8
 * {@code @description:}
 */
public class Solution1 {

    /**
     * 给一个0 1 数组，相邻的不可以是1，求最多还可以向数组中插入多少1
     * 暴力：如果我们想知道怎样安置1，可以最多，那么暴力的方法就是列举出所有情况
     * 题做多了，就会有一种感应，觉得可以用贪心来做，至于行不行，要看题目的测试用例是否能通过
     * 贪心：从左到右遍历，如果左右邻居都为0，那么就可以安置1，然后按此规律，继续遍历
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");

        int res = process(split);

        System.out.println(res);
    }

    private static int process(String[] split) {
        int res = 0;
        for (int i = 0; i < split.length; i++) {
            if (i == 0 && split[i] == "0" && split[i + 1] == "0") {
                split[i] = "1";
                res++;
            } else if (i == split.length - 1 && split[i] == "0" && split[i - 1] == "0") {
                split[i] = "1";
                res++;
            }else if (split[i] == "0" && split[i - 1] == "0" && split[i + 1] == "0") {
                split[i] = "1";
                res++;
            }
        }
        return res;
    }
}
