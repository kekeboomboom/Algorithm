package leetcode;

/**
 * @author keboom
 * @date 2021/8/16
 */
public class LeetCode59 {

    int curNum = 1;

    public int[][] generateMatrix(int n) {
        int tR = 0;
        int tC = 0;
        int dR = n - 1;
        int dC = n - 1;
        int[][] res = new int[n][n];

        while (tR < dR) {
            process(res, tR++, tC++, dR--, dC--);
        }
        if (tR == dR) {
            res[tR][tC] = curNum;
        }
        return res;
    }

    private void process(int[][] res, int tR, int tC, int dR, int dC) {
        int curR = tR;
        int curC = tC;
        while (curC < dC) {
            res[curR][curC] = curNum;
            curC++;
            curNum++;
        }
        while (curR < dR) {
            res[curR][curC] = curNum;
            curR++;
            curNum++;
        }
        while (curC > tC) {
            res[curR][curC] = curNum;
            curC--;
            curNum++;
        }
        while (curR > tR) {
            res[curR][curC] = curNum;
            curR--;
            curNum++;
        }
    }
}
