package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            swap(nums,left,right);
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
