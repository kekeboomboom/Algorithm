package SwordPointToOffer;

import com.sun.org.apache.xpath.internal.operations.Neg;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/14
 */
public class Offer10_2 {

    public int numWays(int n) {
        if (n <= 2) {
            return n;
        }
        return numWays(n-1)+numWays(n-2);
    }

    public int numWays2(int n,int[] tmp) {
        if (n <= 2) {
            return n;
        }
        if (tmp[n] != 0) {
            return tmp[n];
        }
        return numWays(n - 1) + numWays(n - 2);
    }

    public int numWays3(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        Offer10_2 offer102 = new Offer10_2();

//        int i = offer102.numWays(5);
//        int i = offer102.numWays2(5, new int[6]);

        int i = offer102.numWays3(5);
        System.out.println(i);


    }
}
