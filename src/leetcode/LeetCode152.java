package leetcode;

/**
 * @author keboom
 * @date 2021/8/2
 */
public class LeetCode152 {

    /**
     * 这题我也想到了用两个变量，可是我觉得dp数组只能存储一个变量，所以就放弃思考额
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                curMax = 0;
                curMin = 0;
            } else if (nums[i] > 0) {
                curMax = Math.max(curMax * nums[i], nums[i]);
                curMin = Math.min(curMin * nums[i], nums[i]);
            } else {
                int tmp = curMax;
                curMax = Math.max(curMin * nums[i], nums[i]);
                curMin = Math.min(tmp * nums[i], nums[i]);
            }
            if (curMax > res) {
                res = curMax;
            }
        }
        return res;
    }
}
