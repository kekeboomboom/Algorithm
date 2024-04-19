import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 3, 1, 1, 4};



    }

    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum=0;
        for (int i = 1; i < len - 1; i++) {
            int minH = Math.min(maxLeft[i], maxRight[i]);
            if (minH > height[i]) {
                sum += minH - height[i];
            }
        }
        return sum;
    }

}
