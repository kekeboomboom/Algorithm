package leetcode;

import java.util.HashSet;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/23
 */
public class LeetCode36 {

    /**
     * 就用最原始的方法，一个个去排查
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for (char[] row : board) {
            for (char c : row) {
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
            set = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
            set = new HashSet<>();
        }

        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] == '.') {
                            continue;
                        }
                        if (set.contains(board[k][l])) {
                            return false;
                        }
                        set.add(board[k][l]);
                    }
                }
                set = new HashSet<>();
            }
        }
        return true;
    }


    /**
     * [[".",".","4",".",".",".","6","3","."]
     * ,[".",".",".",".",".",".",".",".","."]
     * ,["5",".",".",".",".",".",".","9","."]
     * ,[".",".",".","5","6",".",".",".","."]
     * ,["4",".","3",".",".",".",".",".","1"]
     * ,[".",".",".","7",".",".",".",".","."]
     * ,[".",".",".","5",".",".",".",".","."]
     * ,[".",".",".",".",".",".",".",".","."]
     * ,[".",".",".",".",".",".",".",".","."]]
     */
}
