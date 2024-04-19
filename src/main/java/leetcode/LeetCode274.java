package leetcode;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/16
 */
public class LeetCode274 {


    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
