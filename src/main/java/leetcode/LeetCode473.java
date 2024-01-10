package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/10
 * {@code @description:}
 */
public class LeetCode473 {

    /**
     * 每个只能使用一次，那么排序求和，sum/4，得到每个边长。
     * 这题我卡点在于，如何进行遍历，才能将数组分成4份边长相等的四份
     * <p>
     * 看完题解后，题解的思路是，对于每个数字，无非就四种情况（四条边）。我们一次遍历每个数字，将每个数组分别放入四个边进行尝试，那么就能遍历出所有情况。
     * trick：我们将数组从大到小排序，这样能够快速失败，因为大的数相加会快速超出范围。
     *
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        int[] sortedSticks = Arrays.stream(matchsticks).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).mapToInt(Integer::intValue).toArray();
        if (sum % 4 != 0) {
            return false;
        }
        int sideLen = sum / 4;
        return dfs(sideLen, new int[4], 0,sortedSticks);
    }

    private boolean dfs(int sideLen, int[] side, int index, int[] sortedSticks) {
        if (index == sortedSticks.length) {
            return true;
        }
        for (int i = 0; i < side.length; i++) {
            side[i] += sortedSticks[index];
            if (side[i] <= sideLen && dfs(sideLen, side, index + 1, sortedSticks)) {
                return true;
            }
            side[i] -= sortedSticks[index];
        }
        return false;
    }
}
