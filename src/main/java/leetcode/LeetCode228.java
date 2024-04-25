package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/25
 */
public class LeetCode228 {

    /**
     * 首先理解题意，根据题目案例来说吧，[0,1,2,4,5,7]  0，1，2 这三个连续的就可以合并成一个区间来表示，0-2   4，5也是可以合并成一个区间表示 4-5  7 单独他自己
     * 注意，数字之间连续的才能进行区间合并
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (start == end) {
                    result.add(nums[start] + "");
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
            }else{
                if (nums[i + 1] - nums[i] == 1) {
                    end = i + 1;
                } else {
                    if (start == end) {
                        result.add(nums[start] + "");
                    } else {
                        result.add(nums[start] + "->" + nums[end]);
                    }
                    start = i + 1;
                    end = i + 1;
                }
            }
        }
        return result;
    }
}
