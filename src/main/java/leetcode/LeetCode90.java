package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/22
 */
public class LeetCode90 {
    ArrayList<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (index > nums.length) {
            return;
        } else {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backtracking(nums,i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
