package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/16
 */
public class LeetCode40 {

    ArrayList<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            if (sum > target) {
                break;
            }
            tmp.add(candidates[i]);
            backtracking(candidates,target,i+1,sum);
            sum -= candidates[i];
            tmp.remove(tmp.size() - 1);
        }
    }
}
