package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/19
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        int length = split[split.length - 1].length();
        return length;
    }

    public static void main(String[] args) {
        LeetCode58 leetCode58 = new LeetCode58();
        int i = leetCode58.lengthOfLastWord("   fly me   to   the    moon  ");

        System.out.println(i);
    }
}
