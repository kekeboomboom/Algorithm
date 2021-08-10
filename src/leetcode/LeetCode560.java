package leetcode;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode560 {

    /**
     * 前缀和          437. 路径总和 III  这道题也是前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}
