package zuo.chapter4;

/**
 * 最长公共子串
 * @author keboom
 * @date 2021/6/7
 */
public class LongestCommonSubStr {

    /**
     * 注意这个dp数组的意义：
     * dp[i][j]的含义是，str1[i]和 str2[j]当作公共子串最后一个字符的情况下，公共子串最长能有多长
     * @param str1
     * @param str2
     * @return
     */
    public int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < str2.length; i++) {
            if (str1[0] == str2[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    public String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
}
