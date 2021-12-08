package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        process(nums, nums.length, 0, tmp, res, used);
        return res;
    }

    private void process(int[] nums, int len, int depth, LinkedList<Integer> tmp, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                tmp.addLast(nums[i]);
                used[i] = true;

                process(nums,len,depth+1,tmp,res,used);

                used[i] = false;
                tmp.removeLast();
            }
        }
    }

}
