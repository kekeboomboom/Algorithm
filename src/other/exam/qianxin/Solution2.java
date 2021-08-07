package other.exam.qianxin;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/7
 */
public class Solution2 {

    boolean[][] isGo;
    int res = 0;
    int[][] skill;
    public int getMaximumResource (int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        isGo = new boolean[row][col];
        skill = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        // 那些为0的设置为false
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                isGo[i][j] = grid[i][j] == 0 ? false : true;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    process(grid, i, j, isGo, 0);
                }
            }
        }
        return res;
    }

    private void process(int[][] grid, int i, int j, boolean[][] isGo, int sum) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || !isGo[i][j]) {
            return;
        }
        isGo[i][j] = false;
        sum += grid[i][j];
        res = Math.max(res, sum);
        for (int[] s : skill) {
            int newX = i + s[0];
            int newY = j + s[1];
            process(grid, newX, newY, isGo, sum);
        }
        isGo[i][j] = true;
    }

    //[[0,6,0],[5,8,7],[0,9,0]]
    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int res = new Solution2().getMaximumResource(grid);
        System.out.println(res);
    }

}

/*
给你一个网格，你可以从任意位置进入和退出。
你不可以走重复的路
你不可以走0
你可以上下左右走
你进入一个网格则能收集此网格的资源，求你能收集最大的资源数
[[0,6,0],[5,8,7],[0,9,0]]

24
路径：7-8-9

[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]

28
路径：1-2-3-4-5-6-7
 */
