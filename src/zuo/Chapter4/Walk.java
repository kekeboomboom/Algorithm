package zuo.Chapter4;

/**
 * @author keboom
 * @date 2021/3/20 14:56
 */
public class Walk {

    // 暴力递归
    public int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return walk(N, cur + 1, rest - 1, P);
        } else if (cur == N) {
            return walk(N, cur - 1, rest - 1, P);
        } else {
            return walk(N, cur - 1, rest - 1, P) + walk(N, cur + 1, rest - 1, P);
        }
    }

    // 动态规划
    public int walk2(int N, int cur, int rest, int P) {
        int[][] dp = new int[rest + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == P) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[rest][cur];
    }

    // 滚动数组
    public int walk3(int N, int cur, int rest, int P) {
        int[] dp = new int[N+1];
        dp[P] = 1;
        for (int i = 1; i <= rest; i++) {
            int leftup = dp[1];
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[2];
                } else if (j == N) {
                    dp[j] = leftup;
                } else {
                    dp[j] = dp[j+1] + leftup;
                }
                leftup = tmp;
            }
        }
        return dp[cur];
    }
}
