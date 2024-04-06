package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/6
 */
public class LeetCode189 {

    /**
     * 最简单的方法，搞一个队列，要链表队列
     * 然后将 k 个从队列尾部依次放到队列头部。
     * 然后再讲队列中数组放到 nums
     *
     * 这样做超出时间限制
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            deque.addLast(num);
        }
        for (int i = 0; i < k; i++) {
            Integer last = deque.removeLast();
            deque.addFirst(last);
        }
        for (int i = 0; i < deque.size(); i++) {
            nums[i] = deque.get(i);
        }
    }


    /**
     * 我需要一个额外的存储空间，比如题目中的 1 2 3  4，只是向前移动三位
     * 另外三个 5 6 7 放到一个额外的存储空间中，当 1 2 3 4 移动好后，再将 5 6 7 放到 nums 就行
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        // 有的 k 可能大于 n
        int k2 = k %n ;
        int[] right = new int[k2];
        for (int i = 0; i < k2; i++) {
            right[i] = nums[n-k2+i];
        }
        for (int i = n-k2-1; i >=0; i--) {
            nums[i + k2] = nums[i];
        }
        for (int i = 0; i < right.length; i++) {
            nums[i] = right[i];
        }
    }
}
