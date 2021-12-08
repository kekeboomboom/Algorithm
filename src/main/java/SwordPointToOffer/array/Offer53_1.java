package SwordPointToOffer.array;

/**
 * @author keboom
 * @date 2021/3/13 15:10
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
        /*
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;*/
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[right] && nums[left] == target) {
                return right - left + 1;
            }
            if (nums[left] < target) {
                left++;
            }
            if (nums[right] > target) {
                right--;
            }
        }
        return 0;
    }
}
