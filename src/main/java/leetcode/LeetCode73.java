package leetcode;

import java.util.HashSet;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/24
 */
public class LeetCode73 {


    /**
     * 先遍历矩阵中的是 0 的位置，记录此位置的横纵坐标，当然要进行去重，我们使用 set 来记录横纵坐标
     * 接着，遍历矩阵所有节点，如果当前节点的横纵坐标包含于 set，那么当前节点应该置为 0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
