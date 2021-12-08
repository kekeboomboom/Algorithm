package zuo.chatper8;

/**
 * 顺时针打印矩阵
 * @author keboom
 * @date 2021/6/25
 */
public class SpiralOrderPrint {

    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) { // only one row
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) { // only one col
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
}
