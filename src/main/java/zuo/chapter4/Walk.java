package zuo.chapter4;

/**
 * @author keboom
 * @date 2021/3/18
 */
public class Walk {

    // N : 位置为 1 ~ N，固定参数
    // cur : 当前在 cur 位置，可变参数
    // rest : 还剩 res 步没有走，可变参数
    // P : 最终目标位置是 P，固定参数
    public int way1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    // 暴力递归
    public int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }

        if (cur == 1) {
            return walk(N, 2, rest - 1, P);
        }
        if (cur == N) {
            return walk(N, N - 1, rest - 1, P);
        }
        return walk(N, cur - 1, rest - 1, P) + walk(N, cur + 1, rest - 1, P);
    }

    // 动态规划
    public int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for (int i = 1; i < K + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][M];
    }

    /**
     * 动态规划优化————滚动数组
     */
    public int ways3(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i < K + 1; i++) {
            int left = 0;
            for (int j = 1; j < N + 1; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[j + 1];
                } else if (j == N) {
                    dp[j] = left;
                } else {
                    dp[j] = left + dp[j + 1];
                }
                left = tmp;
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        Walk walk = new Walk();
        System.out.println(walk.ways3(7,6,9,5));
    }
}
