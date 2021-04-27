package leetcode;

/**
 * @author keboom
 * @date 2021/2/25
 */
public class LeetCode59two {
    public int[][] generateMatrix(int n) {
        int l = 0, t = 0;
        int r = n - 1, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        int tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int n = 3;
//        LeetCode59two leetCode59two = new LeetCode59two();
//        int[][] res = leetCode59two.generateMatrix(3);
//        for (int[] re : res) {
//            for (int i : re) {
//                System.out.print(i);
//            }
//        }
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                return;
            }
            System.out.println(i);
        }
    }
}
