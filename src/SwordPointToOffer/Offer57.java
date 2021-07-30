package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }
}
