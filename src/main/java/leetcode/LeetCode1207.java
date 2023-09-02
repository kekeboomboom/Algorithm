package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/2
 */
public class LeetCode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int i : arr) {
            if (numCount.containsKey(i)) {
                numCount.put(i, numCount.get(i) + 1);
            } else {
                numCount.put(i, 1);
            }
        }
        HashSet<Integer> count = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> entries = numCount.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (count.contains(entry.getValue())) {
                return false;
            }
            count.add(entry.getValue());
        }
        return true;
    }
}
