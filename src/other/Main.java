package other;

import java.util.Arrays;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class Main {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int X = sc.nextInt();
//        int K = sc.nextInt();
//        int[] cups = new int[N + 1];
//        cups[X] = 1;
//        for (int i = 0; i < K; i++) {
//            int cup1 = sc.nextInt();
//            int cup2 = sc.nextInt();
//            swap(cups,cup1,cup2);
//        }
//        for (int i = 1; i <= cups.length; i++) {
//            if (cups[i] == 1) {
//                System.out.println(i);
//                return;
//            }
//        }
//    }
//
//    private static void swap(int[] cups, int i, int j) {
//        int tmp = cups[i];
//        cups[i] = cups[j];
//        cups[j] = tmp;
//    }

    static int n;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] zhan = new int[n + k];
        for (int i = 0; i < n; i++) {
            zhan[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = maxZao(zhan);
        }
        System.out.println(max);
    }

    private static int maxZao(int[] zhan) {
        Arrays.sort(zhan);
        int max = 0;
        int index=0;
        for (int i = 1; i < zhan.length; i++) {
            if (zhan[i] - zhan[i - 1] > max) {
                max = zhan[i] - zhan[i - 1];
                index = i;
            }
        }
        k--;
        zhan[n++] = (zhan[index] - zhan[index - 1])/2;
        return max;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        char[][] mi = new char[n][m];
//        String s2 = sc.nextLine();
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            System.out.println(i+ "~~~~~");
//            for (int j = 0; j < s.length(); j++) {
//                mi[i][j] = s.charAt(j);
//            }
//        }


//        int[][] dp = new int[n][m];
//        dp[0][0] = 0;
//        for (int i = 1; i < n; i++) {
//            if (mi[i][0] == '#') {
//                dp[i][0] = dp[i - 1][0] + 1;
//            } else {
//                dp[i][0] = dp[i - 1][0];
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            if (mi[0][i] == '#') {
//                dp[0][i] = dp[0][i - 1] + 1;
//            } else {
//                dp[0][i] = dp[0][i - 1];
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
//            }
//        }
//        System.out.println(dp[n-1][m-1]);

}
