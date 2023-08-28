package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/28
 */
public class LeetCode1679 {

    /**
     * 我认为这题需要先排序，如果不先排序的话，要找到两个数字之和为k，那么需要n的平方时间复杂度
     * 那么先排序，然后再左右指针去找，那么时间复杂度就是排序算法的时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int pairs = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                pairs++;
                left++;
                right--;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        LeetCode1679 leetCode1679 = new LeetCode1679();
        int[] nums = {1, 2, 3, 4};
        int i = leetCode1679.maxOperations(nums, 5);

        System.out.println(i);
    }
}
