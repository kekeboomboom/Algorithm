package SwordPointToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer57II {

    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][]{{target}};
        }
        int left = 1;
        int right = 2;
        int sum = left + right;
        List<int[]> res = new ArrayList<>();

        while (right <= target / 2 + 1) {
            if (sum > target) {
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = left + i;
                }
                res.add(tmp);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
