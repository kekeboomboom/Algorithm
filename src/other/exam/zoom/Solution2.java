package other.exam.zoom;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/28
 */
public class Solution2 {

    public int[] slideWindow(int[] nums, int windowSize, int step) {
        int left = 0;
        int right = windowSize-1;
        int resLen = 0;
        if (nums.length % 2 == 0) {
            resLen = nums.length / step;
        } else {
            resLen = (nums.length+1)/step;
        }
        int[] res = new int[nums.length / step];
        int resIndex = 0;
        while (left < nums.length) {
            findMax(nums, left, right,res,resIndex);
            left += step;
            right += step;
            resIndex++;
        }
        return res;
    }

    private void findMax(int[] nums, int left, int right, int[] res, int resIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (i == nums.length) {
                break;
            }
            max = Math.max(max, nums[i]);
        }
        res[resIndex] = max;
    }


    //[1,3,-1,-3,5,3,6,7],3,2
    //[1,3,-1,-3,5,3,6,7],3,1
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = new Solution2().slideWindow(nums, 3, 2);
        System.out.println(Arrays.toString(res));
    }
}
