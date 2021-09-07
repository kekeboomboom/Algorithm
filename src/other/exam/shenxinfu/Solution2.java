package other.exam.shenxinfu;

/**
 * @author keboom
 * @date 2021/8/31
 */
public class Solution2 {

    // 那个传染的小岛问题咋写累着。。。


    int doctor = 0;
    int[][] skill = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int ncov_defect(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        if (col == 0 || row == 0) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    hero(grid, i, j);
                }
            }
        }
        return doctor;
    }

    private void hero(int[][] grid, int i, int j) {
        for (int[] s : skill) {
            int newX = i + s[0];
            int newY = j + s[1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 1 || grid[newX][newY] == 2) {
                continue;
            }
            grid[newX][newY] = 2;
            doctor++;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][8];
        grid[0][1] = 1;
        grid[0][7] = 1;
        grid[1][1] = 1;
        grid[1][7] = 1;
        grid[2][7] = 1;
        int i = new Solution2().ncov_defect(grid);
        System.out.println(i);
    }
}
