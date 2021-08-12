package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/11
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 10000;
        for (int i = 0; i < len-2; i++) {
            int tmp = target - nums[i];
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                res = Math.abs(nums[i]+sum - target) < Math.abs(res - target) ? nums[i] + sum : res;
                if (sum > tmp) {
                    right--;
                } else if (sum < tmp) {
                    left++;
                } else {
                    return nums[i] + sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MAX_VALUE + 1));
    }
}
