package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/5
 */
public class LeetCode2352 {

    /**
     * 创建两个map，分别记录行 和 列。map的key为行或者列拼接的字符串，value为行或者列的索引值
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> mapRow = new HashMap<>(n);
        HashMap<String, Integer> mapCol = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String rowKey = Arrays.stream(grid[i]).mapToObj(String::valueOf).collect(Collectors.joining(","));
            if (mapRow.containsKey(rowKey)) {
                mapRow.put(rowKey, mapRow.get(rowKey) + 1);
            } else {
                mapRow.put(rowKey, 1);
            }

            int[] colArr = new int[n];
            for (int j = 0; j < n; j++) {
                colArr[j] = grid[j][i];
            }
            String colKey = Arrays.stream(colArr).mapToObj(String::valueOf).collect(Collectors.joining(","));
            if (mapCol.containsKey(colKey)) {
                mapCol.put(colKey, mapCol.get(colKey) + 1);
            } else {
                mapCol.put(colKey, 1);
            }
        }
        int pairs = 0;
        for (String rowKey : mapRow.keySet()) {
            if (mapCol.containsKey(rowKey)) {
                pairs += mapCol.get(rowKey) * mapRow.get(rowKey);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        LeetCode2352 leetCode2352 = new LeetCode2352();
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        int i = leetCode2352.equalPairs(grid);

        System.out.println(i);
    }
}
