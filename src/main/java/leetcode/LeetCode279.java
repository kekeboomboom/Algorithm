package leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode279 {

    /**
     * dp的定义为即使所求结果
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏情况，比如要求n，那就n个1相加，那就是最坏情况了
            dp[i] = i;
            // 我们吧所有情况列出来，n-1,n-4,n-9,n-16 .......取其中最小的
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        double a = 5.5;
        double b = -5.5;
        BigDecimal aDOWN = new BigDecimal(a).setScale(0, RoundingMode.DOWN);
        BigDecimal aUP = new BigDecimal(a).setScale(0, RoundingMode.UP);
        BigDecimal aFLOOR = new BigDecimal(a).setScale(0, RoundingMode.FLOOR);
        BigDecimal aCEILING = new BigDecimal(a).setScale(0, RoundingMode.CEILING);
        System.out.printf("%s, %s, %s, %s", aDOWN, aUP, aFLOOR, aCEILING);
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        BigDecimal bDOWN = new BigDecimal(b).setScale(0, RoundingMode.DOWN);
        BigDecimal bUP = new BigDecimal(b).setScale(0, RoundingMode.UP);
        BigDecimal bFLOOR = new BigDecimal(b).setScale(0, RoundingMode.FLOOR);
        BigDecimal bCEILING = new BigDecimal(b).setScale(0, RoundingMode.CEILING);
        System.out.printf("%s, %s, %s, %s", bDOWN, bUP, bFLOOR, bCEILING);

    }
}
