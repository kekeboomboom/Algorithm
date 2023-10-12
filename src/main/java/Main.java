import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] candiates = {2, 3, 6, 7};
        List<List<Integer>> lists = main.combinationSum(candiates, 7);
        System.out.println();
    }

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0,0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index,int sum) {
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            sum += candidates[i];
            if (sum > target) {
                tmp.remove(tmp.size() - 1);
                break;
            } else if (sum < target) {
                backtracking(candidates, target, i, sum);
                tmp.remove(tmp.size() - 1);
                sum -= candidates[i];
            } else {
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                break;
            }
        }
    }
}
