package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/11
 * {@code @description:}
 */
public class LeetCode120 {

    /**
     * 这是我第一次写出来的
     * 可以优化的点：可以从右向左，这样就不用array.copy了。
     * 自底向上，这样就不用在做一次min了。
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[1];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int[] newDp = Arrays.copyOf(dp, triangle.get(i).size());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer curVal = triangle.get(i).get(j);
                if (j == 0) {
                    newDp[j] = dp[j] + curVal;
                } else if (j == triangle.get(i).size() - 1) {
                    newDp[j] = dp[j - 1] + curVal;
                } else {
                    newDp[j] = Math.min(dp[j], dp[j - 1]) + curVal;
                }
            }
            dp = newDp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    /**
     * 自底向上，这样就不用最后再去查询min了
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
