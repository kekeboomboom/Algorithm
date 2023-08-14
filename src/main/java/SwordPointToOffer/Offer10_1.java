package SwordPointToOffer;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/14
 */
public class Offer10_1 {

//    https://leetcode.cn/leetbook/read/illustration-of-algorithm/m5zfc1/   这篇文章说了，斐波那契属于重叠子问题。对于重叠子问题，有递归，记忆化递归，动态规划
    // 对于递归，其实都是从上到下。记忆化递归，就是在递归的过程中，将已经算过的节点记录下来，下次就可以直接用了。
    // 对于动态规划，都是从下到上的。

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 记忆化递归
     *
     * @param n
     * @param dp
     * @return
     */
    public int fib2(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer10_1 offer101 = new Offer10_1();

//        int fib = offer10.fib(5);

//        int i = offer10.fib2(5, new int[6]);

        int i = offer101.fib3(5);


        System.out.println(i);
    }
}
