package leetcode;

/**
 * @author keboom
 * @date 2021/7/31
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    infect(grid, i, j, row, col);
                }
            }
        }
        return res;
    }

    private void infect(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j, row, col);
        infect(grid, i, j - 1, row, col);
        infect(grid, i + 1, j, row, col);
        infect(grid, i, j + 1, row, col);
    }
}
