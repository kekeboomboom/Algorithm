package leetcode;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    boolean res = process(board, word, 1, i, j, used);
                    if (res == true) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, String word, int index, int i, int j, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }
        boolean res1 = false;
        boolean res2 = false;
        boolean res3 = false;
        boolean res4 = false;

        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(index) && used[i - 1][j] == false) {
            used[i - 1][j] = true;
            res1 = process(board, word, index + 1, i - 1, j, used);
            used[i - 1][j] = false;
        }
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(index) && used[i + 1][j] == false) {
            used[i + 1][j] = true;
            res2 = process(board, word, index + 1, i + 1, j, used);
            used[i + 1][j] = false;
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index) && used[i][j - 1] == false) {
            used[i][j - 1] = true;
            res3 = process(board, word, index + 1, i, j - 1, used);
            used[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(index) && used[i][j + 1] == false) {
            used[i][j + 1] = true;
            res4 = process(board, word, index + 1, i, j + 1, used);
            used[i][j + 1] = false;
        }
        return res1 || res2 || res3 || res4;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean RES = new LeetCode79().exist(board, "ABCCED");
    }
}
