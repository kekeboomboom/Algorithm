package SwordPointToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author keboom
 * @date 2021/3/12
 */
public class JZ {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int j=left;j<=right;j++) {
                res.add(matrix[top][j]);
            }
            top++;
            for (int i=top;i<=bottom;i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int j=right;j>=left;j--){
                res.add(matrix[bottom][j]);
            }
            bottom--;
            for (int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
