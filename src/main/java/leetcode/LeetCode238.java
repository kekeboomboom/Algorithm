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

    /**
     * 创建两个数组，一个数组multiplyLeft放，从左到右的乘积。一个数组multiplyRight放从右到左的乘积。
     * 然后要得到ans，只需要找到 multiplyLeft[i-1] * multiplyRight[i+1]
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] multiplyLeft = new int[len];
        int[] multiplyRight = new int[len];
        multiplyLeft[0]=nums[0];
        // multiplyLeft[i] 为从 0 到 i 的nums 中的所有数字乘积
        for (int i = 1; i < len; i++) {
            multiplyLeft[i] = multiplyLeft[i - 1] * nums[i];
        }
        multiplyRight[len - 1] = nums[len - 1];
        // multiplyRight[i] 为从 i 到 len-1 的nums中所有数字的乘积
        for (int i = len-2; i >=0; i--) {
            multiplyRight[i] = multiplyRight[i + 1] * nums[i];
        }
        int[] ans = new int[len];
        ans[0] = multiplyRight[1];
        ans[len - 1] = multiplyLeft[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = multiplyLeft[i - 1] * multiplyRight[i + 1];
        }
        return ans;
    }


    /**
     * 又有一种方法！！！！！呵呵，不过思路跟上面的一样，但是代码好像简洁了些
     * @param nums
     * @return
     */
    public int[] productExceptSelf3(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        int prefix = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i - 1];
            answer[i] = prefix;
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            answer[i] *= suffix;
        }
        return answer;
    }

    public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
        int[] nums = {1, 2, 3, 4};
        int[] ans = leetCode238.productExceptSelf2(nums);

        System.out.println(Arrays.toString(ans));
    }
}
