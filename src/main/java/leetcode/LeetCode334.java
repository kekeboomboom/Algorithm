package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/22
 */
public class LeetCode334 {

    /**
     * 只要找到三个递增子序列，那么我就找最大值和最小值，找到后，如果最大值索引位置大于最小值索引位置，并且最大值的索引位置要比最小值的索引位置要大至少1
     * 也就说nums中最大值的索引为maxValueIndex, 最小值的为 minValueIndex
     * 如果 maxValueIndex > minValueIndex + 1
     * 则返回true
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minValueIndex = -1;
        int maxValueIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minValueIndex = i;
            }
            if (nums[i] >= max) {
                max = nums[i];
                maxValueIndex = i;
            }
        }
        if (maxValueIndex > minValueIndex + 1) {
            return true;
        }
        return false;
    }

    /**
     * [20,100,10,12,5,13]  这种情况下，直接拿最大值和最小值比较就不可以
     * 因此我的想法是，写一个函数，此函数为取出数组一个区间的最小值。
     * 比如此函数叫 getMinValueIndex(arr,start,end)
     * 那么第一次取整个数组的最小值 getMinValueIndex(nums,0,nums.length-1) 得到最小值的索引位为 i
     * 接着再次调用 getMinValueIndex(nums, i, nums.length-1) 得到最小值索引位为 j ，如果j != nums.length-1 那么返回true
     * <p>
     * <p>
     * 这个思路还是不对，因为符合条件的队列可以在 i 的前面，就是在 （0 ~ i）的范围也可能找到。
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int i = getMinValueIndex(nums, 0, nums.length - 1);
//        if ()
        return false;
    }

    private int getMinValueIndex(int[] nums, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minValueIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minValueIndex = i;
            }
        }
        return minValueIndex;
    }

    /**
     * 还是看了题解，题解的意思是维护两个数组。一个数组定义为：min[i] 为 nums 从0 到 i-1 范围内，最小值
     * 另一个数组定义为： max[i] 为nums 从i+1 到 nums.length-1 范围内，最大值
     * 最后我们遍历nums，只要找到一个nums[i] 大于 min[i] 且 小于max[i]
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet3(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        min[0] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        }
        int[] max = new int[len];
        max[len - 1] = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i + 1], max[i + 1]);
        }

        System.out.println(Arrays.toString(min));
        System.out.println(Arrays.toString(max));

        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > min[i] && nums[i] < max[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 看题解还有一种贪心算法，其实也对，这种问题只需要找到一种可能，那么就可以返回true，那么使用贪心是最应该的
     * 但问题是我们怎么才能在一个数组中最快的找到一个递增子序列。
     * 题解的做法是，给定第一个数和第二个数，去找第三个数，如果第三个数比第二个数大那么就找到最终答案。如果第三个数比第二个数小比第一个数大，那么第三个数就替换第二个数，接着寻找第三个数。如果第三个数比第一个数小，那么第三个数替换第一个数，接着寻找第三个和第二个数
     * @param nums
     * @return
     */
    public boolean increasingTriplet4(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        min[0] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        }
        int[] max = new int[len];
        max[len - 1] = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i + 1], max[i + 1]);
        }

        System.out.println(Arrays.toString(min));
        System.out.println(Arrays.toString(max));

        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > min[i] && nums[i] < max[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode334 leetCode334 = new LeetCode334();
        int[] nums = {1, 5, 0, 4, 1, 3};
        leetCode334.increasingTriplet3(nums);
    }

}
