package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class Offer46 {

    public int translateNum(int num) {
        String n = String.valueOf(num);
        if (n.length() == 1) {
            return 1;
        }
        int[] dp = new int[n.length()];
        dp[0] = 1;
        if (n.length() > 1) {
            if (n.charAt(0) != '0' && Integer.valueOf(n.substring(0, 2)) < 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < n.length(); i++) {
            dp[i] = dp[i-1];
            if (n.charAt(i - 1) != '0' && Integer.valueOf(n.substring(i - 1, i + 1)) < 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n.length() - 1];
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(0,2));
    }
}
