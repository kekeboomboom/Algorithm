package other.exam.huaweiOD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/16
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size1 = in.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = in.nextInt();
        }
        int size2 = in.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = in.nextInt();
        }
        int k = in.nextInt();

        if (k == 0) {
            System.out.println(0);
        }

        HashSet<String> used = new HashSet<>();
        int index1 = 0, index2 = 0;
        int res = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            String use = index1 + "," + index2;
            if (used.contains(use)) {
                index1++;
                continue;
            }
            used.add(use);
            k--;
            res += arr1[index1] + arr2[index2];
            if (k == 0) {
                break;
            }
            if (index1 == arr1.length-1) {
                index2++;
                continue;
            }
            if (index2 == arr2.length-1) {
                index1++;
                continue;
            }
            if (arr1[index1 + 1] > arr2[index2 + 1]) {
                index2++;
            } else {
                index1++;
            }
        }
        System.out.println(res);
    }
}
