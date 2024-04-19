package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/18
 */
public class LeetCode135 {

    /**
     * 两边遍历的思路更符合我。首先初始化所有人的糖果都是1
     * 然后从左向右，如果当前的比你左边的大，那么当前的糖果应该比左边大 1
     * 然后从右向左，如果当前的比你右边的大，那么当前的糖果应该比右边大 1
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        return Arrays.stream(candy).sum();
    }
}
