package leetcode;

import java.util.*;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/22
 */
public class LeetCode47 {

    List<Integer> tmp;
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        tmp = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        backtracking(nums, new HashSet<Integer>());
        return res;
    }

    private void backtracking(int[] nums, HashSet<Integer> used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used.contains(i - 1)) {
                continue;
            }
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            tmp.add(nums[i]);
            backtracking(nums, used);
            tmp.remove(tmp.size() - 1);
            used.remove(i);
        }
    }

    public static void main(String[] args) {
        LeetCode47 leetCode47 = new LeetCode47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = leetCode47.permuteUnique(nums);
        System.out.println(lists);
    }
}
