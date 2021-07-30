package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/22
 */
public class Offer60 {

    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 2];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i; j++) {
                for (int k = 1; k <=6 && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        double all =  Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            res[i-n] = dp[n][i] / all;
        }
        return res;
    }

    public static void main(String[] args) {
        double res = 1 / 6;
        System.out.println(res);
    }
}
