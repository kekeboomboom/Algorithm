package leetcode;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int res = 0;
        int i = x ^ y;
        while (i != 0) {
            i = i & (i - 1);
            res++;
        }
        return res;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
