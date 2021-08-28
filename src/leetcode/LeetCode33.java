package leetcode;

/**
 * @author keboom
 * @date 2021/8/20
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 如果左半边有序
            if (nums[left] <= nums[mid]) {
                // 如果target在左半边中
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        new LeetCode33().search(nums, 0);
        System.out.println(4 + ((6 - 4) >> 1));
    }
}
