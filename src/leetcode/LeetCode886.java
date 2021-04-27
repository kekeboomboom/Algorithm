package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, HashSet<Integer>> table = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            if (!table.containsKey(dislikes[i][0])) {
                HashSet<Integer> set = new HashSet<>();
                set.add(dislikes[i][1]);
                table.put(dislikes[i][0], set);
            }
            table.get(dislikes[i][0]).add(dislikes[i][1]);
        }
        Iterator<Map.Entry<Integer, HashSet<Integer>>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, HashSet<Integer>> next = iterator.next();

        }
        return false;
    }

}
