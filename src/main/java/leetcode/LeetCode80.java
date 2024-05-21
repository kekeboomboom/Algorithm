package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/6
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.put(num, 2);
                }
            } else {
                map.put(num, 1);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                nums[index++] = entry.getKey();
            }
        }
        return index;
    }


    /**
     * 上面是保底做法，肯定还是还要用双指针法。
     * 除了双指针，还要有一个计数，记录right 当前遍历元素的个数，这样 left 可以知道应该走一步还是两步。
     * 还有，当我们遍历的结尾还不算完，如果元素有两个以上的话，实际上 left 只替换了一个
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                count++;
            } else {
                if (count == 1) {
                    left++;
                    nums[left] = nums[right];
                } else {
                    nums[left + 1] = nums[left];
                    left += 2;
                    nums[left] = nums[right];
                }
                count = 1;
            }
        }
        if (count > 1) {
            left++;
            nums[left] = nums[left - 1];
        }
        return left + 1;

    }

    public static void main(String[] args) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 9);
        map.put(0, 4);
        map.put(4, 10);


    }


    public int removeDuplicates3(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < 2 || nums[u - 2] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }


}
