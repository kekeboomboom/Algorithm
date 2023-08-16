package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/4/2
 */
public class Offer42 {

    /**
     * 使用递归，就是遍历所有答案。
     * 记忆化递归，也可以做，就是用二维数组去做，二维数组记录从哪到哪计算过
     * 然后就是动态规划
     * 这个超出内存限制
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[len][len];
        dp[0][0] = nums[0];
        int max = dp[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i - 1][j] <= 0) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(dp[i][j], nums[i] + dp[i - 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 那么就用一维数组
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] <=0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
