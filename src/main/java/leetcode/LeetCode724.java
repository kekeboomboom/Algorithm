package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/2
 */
public class LeetCode724 {

    /**
     * 记录两个数组，一个数组存储从左往右的前缀和，一个数组存储从右往左后缀和
     * 之后遍历其中一个数组，如果某个位置的两个数组上的值相等，那么就返回该索引。如果找不到，那么返回-1
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode724 leetCode724 = new LeetCode724();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = leetCode724.pivotIndex(nums);

        System.out.println(i);
    }
}
