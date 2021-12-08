package other.exam.youzan;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution2 {

    public boolean isMonotonic (int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums.length == 2) {
            return nums[0] != nums[1];
        }
        if (nums[0] == nums[1]) {
            return false;
        }
        // 单调递增则为1，递减则为-1
        int zj = nums[0] > nums[1] ? -1 : 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (zj == 1) {
                if (nums[i] >= nums[i + 1]) {
                    return false;
                }
            } else {
                if (nums[i] <= nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
