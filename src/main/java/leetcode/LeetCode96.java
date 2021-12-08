package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode96 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int num = 0;

        for (int j = 0; j < n; j++) {
            num += numTrees(j) * numTrees(n - 1 - j);
        }

        return num;
//        if (n < 3) {
//            return n;
//        }
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//        dp[2] = 5;
//
//        for (int i = 3; i < n; i++) {
//            dp[i] = dp[i - 1] * i;
//        }
//
//        return dp[n - 1];
        // 我以为是找规律，但应该在树结构上找

        // G(3)=f(1)+f(2)+f(3)
        // f函数为以i为根节点的种数
        // f(1) = G(0)+G(3) f(2) = G(1)+G(1) ...

//        int[] dp = new int[n+1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i < n + 1; i++) {
//            for (int j = 1; j < i + 1; j++) {
//                dp[i] += dp[j-1] * dp[i-j];
//            }
//        }
//        return dp[n];
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
