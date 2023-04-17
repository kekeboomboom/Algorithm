package NowCoder;

public class BM66 {

    public String LCS (String str1, String str2) {
        // write code here
        int maxLength = 0;
        int index = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
                maxLength = 1;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (str1.charAt(0) == str2.charAt(i)) {
                dp[0][i] = 1;
                maxLength = 1;
            }
        }
        if (str1.length() == 1 || str2.length() == 1) {
            if (maxLength == 1) {
                return str1.length() == 1 ? str1 : str2;
            } else {
                return "";
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return str1.substring(index - maxLength + 1, index + 1);
    }
}
