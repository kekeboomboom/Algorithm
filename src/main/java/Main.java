import common.ListNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(7 / 10);

    }


    /**
     * 岛屿问题，套模版。21年做过，左神。
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int landNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    land(grid, i, j);
                    landNum++;
                }
            }
        }
        return landNum;
    }

    private void land(char[][] grid, int row, int col) {
        if (!isArea(grid, row, col)) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        land(grid, row - 1, col);
        land(grid, row + 1, col);
        land(grid, row, col - 1);
        land(grid, row, col + 1);
    }

    private boolean isArea(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
