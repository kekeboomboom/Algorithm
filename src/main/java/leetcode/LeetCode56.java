package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/25
 */
public class LeetCode56 {


    /**
     * 我有印象做过，他是一个排序问题，start 正序排，end 逆序排
     * 当前的 end 大于等于下一个元素的 start，那么说明是重叠的
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length-1) {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(start);
                item.add(end);
                list.add(item);
                break;
            }
            if (intervals[i][1] >= intervals[i + 1][0]) {
                end = Math.max(intervals[i + 1][1], end);
            } else {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(start);
                item.add(end);
                list.add(item);
                start = intervals[i + 1][0];
                end = intervals[i + 1][1];
            } 
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;

    }
}
