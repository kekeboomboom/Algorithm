package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/9
 * {@code @description:}
 */
public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        int arrowNum = 0;
        int index = 0;
        while (index < points.length) {
            // 注意这个 rightMin，我们需要找的右边的最小值
            int rightMin = points[index][1];
            while (index + 1 < points.length && points[index + 1][0] <= rightMin) {
                index++;
                rightMin = Math.min(rightMin, points[index][1]);
            }
            arrowNum++;
            index++;
        }
        return arrowNum;
    }

    public static void main(String[] args) {
        //[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
        LeetCode452 leetCode452 = new LeetCode452();
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int minArrowShots = leetCode452.findMinArrowShots(points);
    }

//    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, Comparator.comparingLong((int[] pre) -> pre[0]));
//
//        int res = 1;
//        int rightMin = points[0][1];
//
//        for (int i = 0; i < points.length; i++) {
//            if (points[i][0] > rightMin) {
//                rightMin = points[i][1];
//                res++;
//            }else{
//                rightMin = Math.min(rightMin, points[i][1]);
//            }
//        }
//        return res;
//    }
}
