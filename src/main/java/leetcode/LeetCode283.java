package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode283 {

    /**
     * 暴力解法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                for (int j = i+1; j < len; j++) {
                    if (nums[j] != 0) {
                        swap(nums,i,j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 快排思想，将不等于0的放左边，等于零的放右边
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    /**
     * 遍历数组，如果当前为0，则向后交换一个不为0的数字
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                int tmp = index + 1;
                while (tmp<nums.length && nums[tmp] == 0) {
                    tmp++;
                }
                if (tmp == nums.length) {
                    break;
                }
                swap(nums, index, tmp);
            }
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        LeetCode283 leetCode283 = new LeetCode283();
        leetCode283.moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
