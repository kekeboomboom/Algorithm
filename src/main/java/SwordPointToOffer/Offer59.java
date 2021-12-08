package SwordPointToOffer;

import java.util.*;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>(((o1, o2) -> o2 - o1));

        map.put(1, 0);
        map.put(5, 2);
        for (Integer i : map.keySet()) {
            System.out.println(i);
        }
    }
}
