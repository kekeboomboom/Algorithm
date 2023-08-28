package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/28
 */
public class LeetCode643 {

    /**
     * 滑动窗口，维护一个窗口，计算每个窗口的平均值，取出最大平均值
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAverage;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAverage = (double) sum / k;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        LeetCode643 leetCode643 = new LeetCode643();
        int[]nums = {4, 0, 4, 3, 3};
        leetCode643.findMaxAverage(nums, 5);

        System.out.println((double) 14/5);
    }
}
