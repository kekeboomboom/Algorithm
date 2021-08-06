package leetcode;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt=0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
