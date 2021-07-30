package leetcode;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int index = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid -1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (index == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int l = index;
        int r = index;
        while (l-1 >= 0 && nums[l - 1] == target) {
            l--;
        }
        while (r+1 < nums.length && nums[r + 1] == target) {
            r++;
        }
        return new int[]{l, r};
    }
}
