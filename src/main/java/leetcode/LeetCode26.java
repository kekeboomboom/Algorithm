package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/12
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return i+1;
    }
}
