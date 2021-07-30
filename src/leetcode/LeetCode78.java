package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        process(nums, tmp, res, 0);
        return res;
    }

    private void process(int[] nums, List<Integer> tmp, List<List<Integer>> res, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            process(nums, tmp, res, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
