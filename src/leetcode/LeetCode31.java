package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
                Arrays.sort(nums,i+1,len);
                return;
            }
        }
        Arrays.sort(nums);
//        int left = 0,right = len-1;
//        while (left < right) {
//            int tmp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = tmp;
//            left++;
//            right--;
//        }

    }

    public static void main(String[] args) {
        int[] test = {1,3,2};
        Arrays.sort(test,1,3);
        System.out.println(Arrays.toString(test));
    }
}
