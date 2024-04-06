package leetcode;

import SwordPointToOffer.JZ;

public class LeetCode27 {

    /**
     * 遍历 nums，如果遍历到的元素等于 val，则向后移动
     * 我的想法是做交换，将等于 val 的都换到后面。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && i != nums.length - 1) {
                int swapIndex = i + 1;
                while (val == nums[swapIndex]) {
                    swapIndex++;
                    if (swapIndex == nums.length) {
                        return i;
                    }
                }
                swap(nums, i, swapIndex);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 实际上我们可以用双指针的方式去做。
     * 比如快慢指针。
     * 快指针去前面找不等于 val 的，换到慢指针的位置，直到快指针走到 nums 结尾。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 还可以左右指针
     * 初始化，左指针就在 0. 右指针需要从右边找到非 val 的
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}