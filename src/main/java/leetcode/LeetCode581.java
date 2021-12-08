package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode581 {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE,left = -1;
        int max = Integer.MIN_VALUE,right = -1;
        for (int i = 0; i < len; i++) {
            if (min < nums[len - i - 1]) {
                left = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,2};
        int[] clone = nums.clone();
        System.out.println(Arrays.toString(clone));
    }
}
