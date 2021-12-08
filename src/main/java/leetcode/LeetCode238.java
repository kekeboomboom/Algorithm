package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            tmp *= nums[i-1];
            res[i] *= tmp;
        }
        tmp = 1;
        for (int i = len-2; i >=0 ; i--) {
            tmp *= nums[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}
