package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/23
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        process(n, k, tmp, res, 1);
        return res;
    }

    private void process(int n, int k, List<Integer> tmp, List<List<Integer>> res, int cur) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = cur; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            process(n, k, tmp, res, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<Integer> a1 = new ArrayList<>();
//        a1.add(3);
//        a1.remove(3); 错误的，会超出索引
//        a1.remove(a1.size()-1);
        List<List<Integer>> res = new LeetCode77().combine(4, 2);
        System.out.println(res.toString());
    }
}
