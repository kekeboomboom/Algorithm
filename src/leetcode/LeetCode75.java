package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode75 {

    /**
     * 这道题采用三路快排的思想
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // [0, zero) = 0;
        // [zero, i) = 1;
        // [two,len-1) = 2;

        int zero = 0;
        int two = len;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                i++;
                zero++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums,i,two);
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
