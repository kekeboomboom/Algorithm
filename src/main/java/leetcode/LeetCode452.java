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

    /**
     * 求交集，比如现在有 a b c， 如果 ab 有交集，那么求出 ab 交， 接着判断 c 于 ab 交是否有交集，如果有交集，那么求出 abc 交，直到没有交集，那么这一箭就可以将这个交集都射掉。
     * @param points
     * @return
     */
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });
        int arrowNum = 0;
        // 交集的左右端点
        int left = points[0][0], right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 判断是否有交集，如果有交集，则更新 left right。 否则更新 arrowNum
            if (points[i][0] > right) {
                arrowNum++;
                left = points[i][0];
                right = points[i][1];
            } else { // 由于我们去的是交集，所以不会出现 point[i][1] < left
                // 现在就是有交集的情况，我们更新 left right
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            }
        }
        // 最后一个 point 无论是作为交集加入到前面的，还是没有交集独立出来，都需要 arrowNum + 1
        arrowNum++;
        return arrowNum;
    }


    public static void main(String[] args) {
        //[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
        LeetCode452 leetCode452 = new LeetCode452();
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int minArrowShots = leetCode452.findMinArrowShots(points);
    }

}
