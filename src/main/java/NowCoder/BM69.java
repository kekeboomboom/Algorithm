package NowCoder;

public class BM69 {

    public int solve(String nums) {
        if (nums.charAt(0) == '0') {
            return 0;
        }
        if (nums.length() == 1) {
            return 1;
        }
        int len = nums.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if (nums.charAt(1) != '0' && Integer.parseInt(nums.substring(0, 2)) <= 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            int num = Integer.parseInt(nums.substring(i - 1, i + 1));
            if (nums.charAt(i - 1) == '0' && nums.charAt(i) == '0'
                    || nums.charAt(i) == '0' && num > 26) {
                return 0;
            }
            if (nums.charAt(i - 1) != '0' && nums.charAt(i) != '0'
                    && num <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
