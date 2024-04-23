import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 3, 1, 1, 4};

        LinkedList<Integer> integers = new LinkedList<>();

        integers.add(111);
        integers.add(222);
        integers.poll();
        System.out.println(integers.toString());
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
            matrix[curCol++][bottomCol] = matrix[curRow][curCol];
        }
        while (curRow < bottomRow) {
            tmp.add(matrix[bottomRow][bottomCol]);
            matrix[curCol][bottomCol] = tmp.poll();
        }
    }
}
