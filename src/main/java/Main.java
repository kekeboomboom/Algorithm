import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        main.rotate(matrix);

    }


    public void rotate(int[][] matrix) {
        LinkedList<Integer> tmp = new LinkedList<>();
        int topRow = 0;
        int topCol = 0;
        int bottomRow = matrix.length - 1;
        int bottomCol = matrix[0].length - 1;
        while (topRow <= bottomRow && topCol <= bottomCol) {
            traverse2(matrix, topRow++, topCol++, bottomRow--, bottomCol--, tmp);
        }
    }

    private void traverse2(int[][] matrix, int topRow, int topCol, int bottomRow, int bottomCol, LinkedList<Integer> tmp) {
        int curRow = topRow;
        int curCol = topCol;
        while (curCol < bottomCol) {
            tmp.add(matrix[curCol][bottomCol]);
            matrix[curCol][bottomCol] = matrix[curRow][curCol];
            curCol++;
        }
        while (curRow < bottomRow) {
            tmp.add(matrix[bottomRow][bottomCol - (curRow - topRow)]);
            matrix[bottomRow][bottomCol - (curRow - topRow)] = tmp.poll();
            curRow++;
        }
        while (curCol > topCol) {
            tmp.add(matrix[curCol][topCol]);
            matrix[curCol][topCol] = tmp.poll();
            curCol--;
        }
        while (curRow > topRow) {
            matrix[topRow][bottomCol - (curRow-topRow)] = tmp.poll();
            curRow--;
        }
    }
}
