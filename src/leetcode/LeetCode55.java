package leetcode;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        int moreIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > moreIndex) {
                return false;
            }
            moreIndex = Math.max(moreIndex, nums[i] + i);
        }
        return true;
    }
}
