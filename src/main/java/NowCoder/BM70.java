package NowCoder;

import java.util.Arrays;

public class BM70 {

    public int minMoney(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);

        dp[0] = 0;
        for (int i = 1; i < aim + 1; i++) {
            for (int money : arr) {
                if (money <= i && dp[i - money] != aim + 1) {
                    dp[i] = Math.min(dp[i], dp[i - money] + 1);
                }
            }
        }
        if (dp[aim] == aim + 1) {
            return -1;
        }
        return dp[aim];
    }


    public static void main(String[] args) {
        int[] arr = {357, 322, 318, 181, 22, 158, 365};
        BM70 bm70 = new BM70();
        int i = bm70.minMoney(arr, 4976);
        System.out.println(i);
    }

}
