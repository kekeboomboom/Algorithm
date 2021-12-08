package other.exam.NETEASE;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        int M = sc.nextInt();
//        System.out.println(Arrays.toString(nums));
//        System.out.println(M);

        int res = sumBiggerM(nums, M);
        System.out.println(res);
    }

    private static int sumBiggerM(int[] nums, int M) {
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= M) {
                    res++;
                }
            }
        }
        return res;
    }
}
