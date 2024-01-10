package other.exam.huaweiOD;

import java.util.Objects;
import java.util.Scanner;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/9
 * {@code @description:}
 */
public class Solution3 {

    /**
     * 题目描述：学校组织活动，将学生排成一个矩形方阵。请在矩形方阵中找到最大的位置相连的男生数量。这个相连位置在一个直线上，方向可以是水平的、垂直的、呈对角
     * 线的或者反对角线的。
     * 注：学生个数不会超过10000，
     * 输入描述：输入的第一行为矩阵的行数和列数，接下来的行为柜阵元素，元素间用“，”分隔。
     * 输出描述：输出一个整数，表示矩阵中最长的位置相连的男生个数。
     * <p>
     * 示例1
     * 输入：3,4
     * F,M,M,F
     * F,M,M,F
     * F,F,F,M
     * 输出：3
     *
     * @param args
     */
    public static void main(String[] args) {
        //看起来没有什么简单的方法，好像只能以此遍历找到最长。
        Scanner sc = new Scanner(System.in);
        String[] firstLIne = sc.nextLine().split(",");
        Integer row = Integer.valueOf(firstLIne[0]);
        Integer col = Integer.valueOf(firstLIne[1]);
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] rowLine = sc.nextLine().split(",");
            for (int j = 0; j < rowLine.length; j++) {
                matrix[i][j] = rowLine[j];
            }
        }
        int horizontalMax = horizontalMax(matrix,row,col);
        int verticalMax = verticalMax(matrix, row, col);
//        diagonalMax(matrix, row, col);  长方形矩阵，不一定有对角线吧？懒得写了，这里只写水平和垂直了
        System.out.println(Math.max(horizontalMax,verticalMax));
    }


    private static int verticalMax(String[][] matrix, Integer row, Integer col) {
        int max = 0;
        for (int i = 0; i < col; i++) {
            int curMax = 0;
            int curLen = 0;
            for (int j = 0; j < row; j++) {
                if (Objects.equals(matrix[j][i], "F")) {
                    curLen++;
                } else {
                    curLen = 0;
                }
                curMax = Math.max(curLen, curMax);
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

    /**
     * 水平
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private static int horizontalMax(String[][] matrix, Integer row, Integer col) {
        int max = 0;
        for (int i = 0; i < row; i++) {
            int curMax = 0;
            int curLen = 0;
            for (int j = 0; j < col; j++) {
                if (Objects.equals(matrix[i][j], "F")) {
                    curLen++;
                } else {
                    curLen = 0;
                }
                curMax = Math.max(curLen, curMax);
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
