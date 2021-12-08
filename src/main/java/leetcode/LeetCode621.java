package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode621 {

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int cnt = 1;
        for (int i = 24; i >= 0; i--) {
            if (count[i] != count[25]) {
                break;
            }
            cnt++;
        }
        return Math.max(len, cnt + (n + 1) * (count[25] - 1));
    }
}
