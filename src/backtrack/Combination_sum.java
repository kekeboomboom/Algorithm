package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keboom
 * @date 2020/11/6
 */
public class Combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                    break;
                }
                tempList.add(candidates[i]);
                sum += candidates[i];
                backtrack(list, tempList, candidates, target, sum, i);
                sum -= candidates[i];
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
