package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLen += 1;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
