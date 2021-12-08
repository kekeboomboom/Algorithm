package leetcode;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n - 2; ) {
            int j = i;
            int d = nums[j + 1] - nums[j];
            while (j + 1 < n && nums[j + 1] - nums[j] == d) {
                j++;
            }
            int len = j - i + 1;
            int a1 = 1,an = len-2;
            int cnt = (a1+an)*an/2;
            res += cnt;
            i = j;
        }
        return res;
    }
}
