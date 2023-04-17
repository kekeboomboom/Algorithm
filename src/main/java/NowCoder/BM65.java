package NowCoder;

public class BM65 {

    public String LCS(String s1, String s2) {
        // write code here
        if (s1.length() == 0 || s2.length() == 0) {
            return "-1";
        }
        String[][] dp = new String[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            if (i > 0 && dp[i - 1][0] != "") {
                dp[i][0] = dp[i - 1][0];
                continue;
            }
            if (s1.charAt(i) == (s2.charAt(0))) {
                dp[i][0] = s2.substring(0, 1);
            } else {
                dp[i][0] = "";
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i > 0 && dp[0][i - 1] != "") {
                dp[0][i] = dp[0][i - 1];
                continue;
            }
            if (s2.charAt(i) == (s1.charAt(0))) {
                dp[0][i] = s1.substring(0, 1);
            } else {
                dp[0][i] = "";
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        if (dp[s1.length() - 1][s2.length() - 1] == "") {
            return "-1";
        }

        return dp[s1.length() - 1][s2.length() - 1];
    }
}
