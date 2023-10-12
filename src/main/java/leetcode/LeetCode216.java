package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/11
 */
public class LeetCode216 {

    List<Integer> tmp;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        tmp = new ArrayList<>(k);
        res = new LinkedList<>();
        backtracking(k, n, 1, 0);
        return res;
    }

    private void backtracking(int k, int n, int index, int sum) {

        for (int i = index; i <= 9; i++) {
            sum += i;
            tmp.add(i);
            if (tmp.size() == k) {
                if (sum > n) {
                    sum -= i;
                    tmp.remove(tmp.size() - 1);
                    break;
                } else if (sum < n) {
                    sum -= i;
                    tmp.remove(tmp.size() - 1);
                } else {
                    res.add(new ArrayList<>(tmp));
                    sum -= i;
                    tmp.remove(tmp.size() - 1);
                    break;
                }
            } else {
                if (sum >= n) {
                    sum -= i;
                    tmp.remove(tmp.size() - 1);
                    break;
                } else {
                    backtracking(k, n, i + 1, sum);
                    sum -= i;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode216 leetCode216 = new LeetCode216();
        List<List<Integer>> lists = leetCode216.combinationSum3(3, 9);

        System.out.println(lists.toString());
    }
}
