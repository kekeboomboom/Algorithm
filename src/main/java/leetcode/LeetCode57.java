package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/25
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0] && start == -1 && intervals[i][0] <=newInterval[0]) {
                start = i;
                end = i;
                continue;
            }
            if (intervals[i][0] <= newInterval[1]) {
                end = i;
            }
        }
        if (start == -1) {
            // 说明不需要合并区间
            int[][] result = new int[intervals.length + 1][2];
            for (int i = 0; i < result.length; i++) {
                if (i==intervals.length || intervals[i][0] > newInterval[0]) {
                    result[i][0] = newInterval[0];
                    result[i][1] = newInterval[1];
                    for (int j = i+1; j < result.length; j++) {
                        result[j][0] = intervals[j - 1][0];
                        result[j][1] = intervals[j - 1][1];
                    }
                    return result;
                } else {
                    result[i][0] = intervals[i][0];
                    result[i][1] = intervals[i][1];
                } 
            }
        }

        for (int i = 0; i < start; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(intervals[i][0]);
            tmp.add(intervals[i][1]);
            list.add(tmp);
        }
        ArrayList<Integer> combine = new ArrayList<>();
        combine.add(Math.min(intervals[start][0],newInterval[0]));
        combine.add(Math.max(intervals[end][1],newInterval[1]));
        list.add(combine);

        for (int i = end + 1; i < intervals.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(intervals[i][0]);
            tmp.add(intervals[i][1]);
            list.add(tmp);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 0};
        leetCode57.insert(intervals, newInterval);
    }
}
