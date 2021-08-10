package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (temperatures[i] > max) {
                res[i] = 0;
            } else if (temperatures[i] < min) {
                res[i] = 1;
            } else {
                for (int j = i+1; j < len; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        res[i] = j-i;
                        break;
                    }
                }
            }
            max = max < temperatures[i] ? temperatures[i] : max;
            min = min > temperatures[i] ? temperatures[i] : min;
        }
        return res;
    }

    /**
     * 使用栈结构，栈顶为最小，栈底为最大
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }
}
