import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();


    }


    /**
     * 挑选出不同的，然后在重新复制到nums 中
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                if (list.getLast() != num) {
                    list.add(num);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    /**
     * 双指针法
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
