package leetcode;

/**
 * @author keboom
 * @date 2021/9/6
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}
