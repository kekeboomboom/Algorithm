package leetcode;

public class LeetCode209 {

    /**
     * 仍然是双指针，数组的题目很多都是双指针。
     * 如果当前和小于target，则右指针向右走
     * 如狗当前和大于等于target，则左指针向右走
     * 初始化：左右指针都在 index=0 的位置
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int curSum = nums[0];
        int left = 0;
        int right = 0;
        if (curSum >= target) {
            return 1;
        }
        while (left <= right && right < nums.length) {
            if (curSum < target) {
                right++;
                if (right == nums.length) {
                    break;
                }
                curSum += nums[right];
            } else {
                curSum -= nums[left];
                left++;
            }
            if (curSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
