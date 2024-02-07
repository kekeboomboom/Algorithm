package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/18
 */
public class LeetCode1049 {

    /**
     * 我们将这题转换为01背包
     * 我们打算将这些石头分为两堆，使这两堆石头重量尽可能接近
     * 那么可以转化成，我们从这堆石头中挑选一些石头，使他们的重量尽可能接近这些石头总重量的一半
     * 这样抵消之后，重量最小。
     * 假设这些石头总重量的一半为 n
     * 那么背包容量为 n ，石头重量与价值为1:1，求解背包最多能装价值最大为？
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagCapacity = sum / 2;
        int target = bagProblem(stones, bagCapacity);
        return sum - target * 2;
    }

    private int bagProblem(int[] items, int bagCapacity) {
        int[] dp = new int[bagCapacity+1];
        for (int i = items[0]; i <= bagCapacity; i++) {
            dp[i] = items[0];
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = bagCapacity; j >= items[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i]] + items[i]);
            }
            if (dp[bagCapacity] == bagCapacity) {
                return bagCapacity;
            }
        }
        return dp[bagCapacity];
    }

    public static void main(String[] args) {
        LeetCode1049 leetCode1049 = new LeetCode1049();
        int[] arr = {31,26,33,21,40};
        leetCode1049.lastStoneWeightII(arr);
    }
}
