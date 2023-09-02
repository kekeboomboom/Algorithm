package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/2
 */
public class LeetCode1732 {

    public int largestAltitude(int[] gain) {
        int curAltitude = 0, maxAltitude = 0;
        for (int i : gain) {
            curAltitude += i;
            maxAltitude = Math.max(maxAltitude, curAltitude);
        }
        return maxAltitude;
    }
}
