package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, res, tmp, 0, 0);
        return res;
    }

    private void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum <= target) {
                tmp.add(candidates[i]);
                process(candidates, target, res, tmp, sum, i);
                tmp.remove(tmp.size() - 1);
                sum -= candidates[i];

            } else {
                break;
            }

        }
    }
}
