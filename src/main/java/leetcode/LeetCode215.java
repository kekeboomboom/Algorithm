package leetcode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums,left,randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }


    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
//        int len = nums.length;
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int i = 0; i < k; i++) {
//            minHeap.add(nums[i]);
//        }
//        for (int i = k; i < len; i++) {
//            Integer topEle = minHeap.peek();
//            if (nums[i] > topEle) {
//                minHeap.poll();
//                minHeap.offer(nums[i]);
//            }
//        }
//        return minHeap.peek();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}
