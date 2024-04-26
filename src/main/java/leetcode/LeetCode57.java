package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/25
 */
public class LeetCode57 {

    /**
     * 这是自己想的，很繁琐，但是让我一下子想到题解写的也不容易吧。而且我这个还有很多漏洞。
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
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
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
                end = i;
            }
        }
        if (end != -1 && start==-1) {
            start = 0;
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


    /**
     * 去算是是否应该和并太繁琐了，直接去找没有交集的，那么剩下的就都是有交集的，然后做并集合并。
     * 还有一个技巧，当找到交集时，那么就可以将他们并集求出来，然后遍历下一个 intervals 时，如果于上次计算出来的并集仍有交集，那么就可以接着跟新这个并集
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(intervals[i]);
            } else if (intervals[i][1] < left) {
                list.add(intervals[i]);
            } else {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }
        if (!placed) {
            list.add(new int[]{left, right});
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 3};
        leetCode57.insert(intervals, newInterval);
    }
}
