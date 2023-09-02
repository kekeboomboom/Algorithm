package leetcode;

import java.rmi.server.UID;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/2
 */
public class LeetCode1493 {

    /**
     * 转换题意，就是寻找一个最长连续子数组，其中最多只能有一个0，剩下的全是1，最终返回最长的长度
     *
     * 这种最长子数组的，一看就用滑动窗口
     * 此题的注意点：
     * 如果left=right那么要注意hasZero的变化。
     * 还有就是对于maxLen的计算，要根据hasZero计算。
     * 如果maxLen跟数组长度一样，那么要减一
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, maxLen = 0;
        boolean hasZero = nums[0] == 0;
        while (right < nums.length) {
            if (nums[right] == 0 ) {
                if (hasZero) {
                    if (nums[left] == 1) {
                        while (nums[left] == 1) {
                            left++;
                        }
                        left++;
                    } else {
                        if (left == right) {
                            hasZero = false;
                        }
                        left++;
                    }
                } else {
                    hasZero = true;
                }
            }
            if (hasZero) {
                maxLen = Math.max(maxLen, right - left);
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        if (maxLen == nums.length) {
            return maxLen - 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode1493 leetCode1493 = new LeetCode1493();
        int[] nums = {0,1,1,1,1,1};
        int i = leetCode1493.longestSubarray(nums);
        System.out.println(i);
    }
}
