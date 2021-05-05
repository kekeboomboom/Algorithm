package zuo;

/**
 * @author keboom
 * @date 2021/4/28
 */
public class Excesize {

    public int walk(int N, int cur, int rest, int P) {
        if (N < 2 || rest < 1 || cur < 1 || cur > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[rest + 1][cur + 1];
        dp[0][P] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j+1];
                } else if (j == N) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
                }
            }
        }
        return dp[rest][cur];
    }


    public static void main(String[] args) {
        Excesize exc = new Excesize();

        System.out.println(exc.walk(5, 2, 3, 3));
    }
}
