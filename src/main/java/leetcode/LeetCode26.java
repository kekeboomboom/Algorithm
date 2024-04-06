package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/12
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return i+1;
    }

    /**
     * 上面的写法不够清晰，还有就是不需要进行交换，而是直接复制就行，此类题让我们写出长度，意思就是超出长度外的数组我们可以不管
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left+1;
    }
}
