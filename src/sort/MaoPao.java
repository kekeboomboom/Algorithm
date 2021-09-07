package sort;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/9/4
 */
public class MaoPao {

    // 冒泡
    public void pao(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // 选择
    public void choice(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }

    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,6,4,8,1};
//        new MaoPao().pao(nums);
        new MaoPao().choice(nums);
        System.out.println(Arrays.toString(nums));
    }
}
