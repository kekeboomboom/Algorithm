package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/17
 */
public class LeetCode1431 {

    /**
     * 首先找到数组中最大数字，然后遍历数组，如果当前数组中值加上extra大于等于最大值，那么就是true
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        ArrayList<Boolean> res = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (max <= (candy + extraCandies)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

}
