package leetcode;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class LeetCode221 {
    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxSide = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0;i < row; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for(int j = 1; j < col; j++){
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][j]);
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int i = maximalSquare(matrix);
        System.out.println(i);

    }
}
