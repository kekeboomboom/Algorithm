package other.exam.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/9/7
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] res = large(matrix, N, K);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] large(int[][] matrix, int N, int K) {
        int[][] res = new int[N * K][N * K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = matrix[i][j];
                for (int k = i*K; k < i*K+K; k++) {
                    for (int l = j*K; l < j*K+K; l++) {
                        res[k][l] = cur;
                    }
                }

            }
        }
        return res;
    }
}
