package leetcode;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode240II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
