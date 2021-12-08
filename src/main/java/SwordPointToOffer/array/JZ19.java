package SwordPointToOffer.array;

import java.util.*;

/**
 * @author keboom
 * @date 2021/3/13 13:56
 */
public class JZ19 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int index = 0;

        // 用left <= right && top <= bottom这个条件的话，由于是矩阵而不是方阵，还得判断如果是省一行或者一列该如何
//        while (left <= right && top <= bottom) {
//            for (int i = left; i <= right; i++) {
//                res[index++] = matrix[top][i];
//            }
//
//            for (int i = top+1; i <= bottom; i++) {
//                res[index++] = matrix[right][i];
//            }
//
//            for (int i = right-1; i >= left; i--) {
//                res[index++] = matrix[bottom][i];
//            }
//
//            for (int i = bottom-1; i >=top+1; i--) {
//                res[index++] = matrix[left][i];
//            }
//            left++;
//            top++;
//            right--;
//            bottom--;
//        }

        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >=top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(++i > 1);
        i = 1;
        System.out.println(i++ > 1);
    }
}
