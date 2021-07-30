package leetcode;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode79II {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        boolean[][] used = new boolean[rows][cols];
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

        for (int[] direction : DIRECTIONS) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY) && board[newX][newY] == word.charAt(index) && !used[newX][newY]) {
                used[newX][newY] = true;
                if (process(board, word, index + 1, newX, newY, used)) {
                    return true;
                }
                used[newX][newY] = false;
            }
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
