package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
