package leetcode;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 摩尔投票法，记录一个数，遇到相同的count+1，否则count-1，如果count=0则更换数字
     * 因为有多数元素大于n/2，所以可以这么做。不同元素抵消掉，最终一定剩余多出来的元素
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count_num = nums[i];
                count = 1;
                continue;
            }
            if (nums[i] == count_num) {
                count++;
            } else {
                count--;
            }
        }
        return count_num;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int i = new LeetCode169().majorityElement2(nums);
        System.out.println(i);
    }
}