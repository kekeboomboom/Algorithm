package other.exam.NETEASE;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution4 {

    public int minSailCost (int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = 0;
        for (int i = 1; i < row; i++) {
            if (dp[i - 1][0] == -1 || input[i][0] == 2) {
                dp[i][0] = -1;
            } else {
                int val = input[i][0] == 0 ? 2 : 1;
                dp[i][0] = dp[i-1][0] + val;
            }
        }
        for (int i = 1; i < col; i++) {
            if (dp[0][i-1] == -1 || input[0][i] == 2) {
                dp[i][0] = -1;
            } else {
                int val = input[0][i] == 0 ? 2 : 1;
                dp[0][i] = dp[0][i-1] + val;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (input[i][j] == 2 || (dp[i - 1][j] == -1 && dp[i][j - 1] == -1)) {
                    dp[i][j] = -1;
                } else {
                    int val = input[i][j] == 0 ? 2 : 1;
                    if (dp[i - 1][j] == -1) {
                        dp[i][j] = dp[i][j-1] + val;
                    } else if (dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - 1][j] + val;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + val;
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }

    // [[1,1,1,1,0],[0,1,0,1,0],[1,1,2,1,1],[0,2,0,0,1]]
    public static void main(String[] args) {
        int[][] input = {{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};

        int res = new Solution4().minSailCost(input);
        System.out.println(res);

    }
}
