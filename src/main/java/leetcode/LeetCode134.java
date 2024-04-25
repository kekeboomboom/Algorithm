package leetcode;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.Set;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/18
 */
public class LeetCode134 {

    /**
     * 这题目如果暴力的话是超时的。
     * 题解给了一种思路，从第一个位置开始走，直到遇到过不去的位置，那么从这个位置接着开始走，看能否走通
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        while (start < gas.length) {
            int step = start;
            int curGas = 0;
            do {
                curGas = curGas + gas[step] - cost[step];
                if (curGas < 0) {
                    break;
                }
                if (step == gas.length - 1) {
                    step = 0;
                } else {
                    step++;
                }
            } while (step != start);
            if (curGas >= 0) {
                return start;
            }
            if (step < start) {
                return -1;
            } else {
                start = step;
            }
        }
        return -1;
    }
}
