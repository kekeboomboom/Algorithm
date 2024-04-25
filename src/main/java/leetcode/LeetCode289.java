package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/24
 */
public class LeetCode289 {

    /**
     * 看题解，没看到特别厉害的取巧方法。有一种是多加两种状态，这样就不仅仅知道现在的状态，还知道之前的状态。
     * 比如从死亡变成存活，那么是状态 2，从存活变成死亡，变成状态-1.
     * 另一个就是很纯朴的方法了。复制一个 board，依次判断每个细胞
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 计算活细胞周围有几个活细胞
                int liveCellNums = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || l < 0 || k >= board.length || l >= board[0].length) {
                            continue;
                        }
                        if (k == i && l == j) {
                            continue;
                        }
                        if (copyBoard[k][l] == 1) {
                            liveCellNums++;
                        }
                    }
                }
                if (copyBoard[i][j] == 1) {
                    if (liveCellNums < 2 || liveCellNums > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (liveCellNums == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
