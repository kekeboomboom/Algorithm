package zuo.chapter4;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/4/18
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {

    // 动态规划，dp数组意义为以第i个元素结尾的最长递增子序列
    // 例如dp[5]，那么要遍历dp[1,2,3,4]等等，dp[i]< dp[5]并且要取dp[i]+1中最大的
    public int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }

    // 根据dp数组的信息：结尾的索引，最长递增子序列的长度。从而求出最长递增子序列
    public int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        // 找出dp数组的最大值
        for (int i = 0; i < arr.length; i++) {
            if (len < dp[i]) {
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[--len] = arr[index];
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }

    // 主方法
    public int[] lengthOfLIS(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }


    // to do 二分法~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] res = test.lengthOfLIS(arr);
        System.out.println(Arrays.toString(res));
    }
}
