package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/5/7
 */
public class LeetCode695 {

    /**
     * leetcode200 等题目，都是一样的模板，岛屿问题统一魔板。https://leetcode.cn/problems/max-area-of-island/description/
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = landArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int landArea(int[][] grid, int row, int col) {
        if (!isArea(grid, row, col)) {
            return 0;
        }
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return 1 +
                landArea(grid, row - 1, col) +
                landArea(grid, row + 1, col) +
                landArea(grid, row, col - 1) +
                landArea(grid, row, col + 1);
    }

    private boolean isArea(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
