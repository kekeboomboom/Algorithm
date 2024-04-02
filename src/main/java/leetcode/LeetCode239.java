package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/2
 */
public class LeetCode239 {

    /**
     * 这道题单调队列
     * 给一个滑动窗口，取每个窗口最大值
     * 一个单调队列，从队列尾部进入，如果进入的元素大于队列尾部的元素，则队尾元素弹出，弹出后，接着让将要进入的元素与队尾元素进行对比，如果大于，则弹出队尾。依次进行
     * 如果即将插入的元素小于等于队尾元素，则直接插入队列
     * 滑动窗口向前走的过程中，除了会新增元素，同时也会删除元素，如果删除的元素与单调队列队头元素相等，则删除单调队列对头元素。
     *
     * 我下面写的肯定是优化的空间，但是我觉着这样写，看起来更清晰些。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
                continue;
            }
            if (deque.getLast() >= nums[i]) {
                deque.add(nums[i]);
                continue;
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = deque.getFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
                result[i - k + 1] = deque.getFirst();
                continue;
            }
            if (deque.getLast() >= nums[i]) {
                deque.add(nums[i]);
                if (deque.getFirst() == nums[i - k]) {
                    deque.removeFirst();
                }
                result[i - k + 1] = deque.getFirst();
                continue;
            }
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
            result[i - k + 1] = deque.getFirst();
        }
        return result;
    }
}
