package leetcode;

/**
 * @author keboom
 * @date 2021/8/3
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
