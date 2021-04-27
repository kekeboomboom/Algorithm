package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keboom
 * @date 2021/3/5
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
