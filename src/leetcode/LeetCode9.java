package leetcode;

/**
 * @author keboom
 * @date 2021/8/11
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) /10;
            div /= 100;
        }
        return true;
    }
}
