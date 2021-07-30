package leetcode;

/**
 * @author keboom
 * @date 2021/7/26
 */
public class LeetCode11 {

    /**
     * 左右指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int res = 0;
        int tmp;
        while (left < right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
