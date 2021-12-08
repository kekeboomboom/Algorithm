package SwordPointToOffer.array;

/**
 * @author keboom
 * @date 2021/3/13 15:28
 */
public class Offer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
