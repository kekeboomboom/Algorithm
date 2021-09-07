package other.exam.LittleRedBook;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/9/4
 */
public class Solution1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] team = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                team[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < team[0].length; j++) {
                // 右下坐标
                for (int k = i; k < team.length; k++) {
                    for (int l = j; l < team[0].length; l++) {
                        // 计算当前矩阵和
                        int sum = caculate(team, i, j, k, l);
                        if (sum > max) {
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int caculate(int[][] team, int i, int j, int k, int l) {
        int sum = 0;
        for (int m = i; m <=k; m++) {
            for (int n = j; n <= l; n++) {
                sum += team[m][n];
            }
        }
        return sum;
    }
}
