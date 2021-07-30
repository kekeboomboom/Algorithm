package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode31 {

    /**
     * 这题先从后往前找到一个顺序的两个连着的数
     * 然后对于第一个数，从后往前找第一个比他大的数，然后交换
     * 然后从i开始到结尾进行排序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i-1] = tmp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }



    public static void main(String[] args) {
        int[] test = {4, 3, 2, 1};
        Arrays.sort(test, 1, 4);
        System.out.println(Arrays.toString(test));
    }
}
