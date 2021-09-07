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

    // left，right指针，向中间夹逼，
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
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    // 将整个数字都反转，然后判断反转后的数字与原数字是否相等，但是效率太低
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int reverseX = 0;
        int tmpX = x;
        while (tmpX > 0) {
            reverseX = reverseX * 10 + tmpX % 10;
            tmpX /= 10;
        }
        System.out.println(reverseX);
        return reverseX == x;
    }

    // 将数字的一半反转，判断是否相等。然后注意处理奇偶
    public boolean isPalindrome4(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reverseX = 0;
        while (reverseX < x) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return reverseX == x || reverseX / 10 == x;
    }

    public static void main(String[] args) {
        boolean res = new LeetCode9().isPalindrome3(32123);
        System.out.println(res);
    }
}
