package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/12
 */
public class LeetCode54 {

    /**
     * 用左神的通用解法吧
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int tr = 0;
        int tc = 0;
        int dr = row - 1;
        int dc = col - 1;
        List<Integer> res = new ArrayList<>();
        while (tr <= dr && tc <= dc) {
            process(matrix, tr++, tc++, dr--, dc--, res);
        }
        return res;
    }

    private void process(int[][] matrix, int tr, int tc, int dr, int dc, List<Integer> res) {
        // 只有一行
        if (tr == dr) {
            for (int i = tc; i <= dc; i++) {
                res.add(matrix[tr][i]);
            }
        } else if (tc == dc) {// 只有一列
            for (int i = tr; i <= dr; i++) {
                res.add(matrix[i][tc]);
            }
        } else {
            int curR = tr;
            int curC = tc;
            while (curC < dc) {
                res.add(matrix[curR][curC]);
                curC++;
            }
            while (curR < dr) {
                res.add(matrix[curR][curC]);
                curR++;
            }
            while (curC > tc) {
                res.add(matrix[curR][curC]);
                curC--;
            }
            while (curR > tr) {
                res.add(matrix[curR][curC]);
                curR--;
            }
        }
    }
}
