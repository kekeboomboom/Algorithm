package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/22
 */
public class LeetCode491 {


    ArrayList<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        if (tmp.size() >= 2) {
            res.add(new ArrayList<>(tmp));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            if (tmp.isEmpty() || nums[i] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                backtracking(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode491 leetCode491 = new LeetCode491();
        int[] nums = {4, 4,3,2,1};
        List<List<Integer>> subsequences = leetCode491.findSubsequences(nums);
        System.out.println(subsequences);
    }
}
