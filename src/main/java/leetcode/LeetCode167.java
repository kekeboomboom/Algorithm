package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/21
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}
