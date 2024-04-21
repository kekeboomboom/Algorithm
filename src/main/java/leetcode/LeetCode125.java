package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/19
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode125 leetCode125 = new LeetCode125();
        boolean raceACar = leetCode125.isPalindrome("race a car");


    }
}
