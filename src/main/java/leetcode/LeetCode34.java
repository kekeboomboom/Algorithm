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

    // 先找到目标target，然后左右扩散
    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0,right=nums.length-1,mid=0;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        }
        left = index;
        right = index;
        while (left >= 0 && nums[left] == nums[index]) {
            left--;
        }
        while (right < nums.length && nums[right] == nums[index]) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
