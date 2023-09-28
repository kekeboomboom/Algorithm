package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/28
 */
public class LeetCode530 {

    long pre = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = getMinimumDifference(root.left);
        int diff = (int) Math.abs(pre - root.val);
        pre = root.val;
        int right = getMinimumDifference(root.right);
        return Math.min(Math.min(left, right), diff);
    }

    public static void main(String[] args) {

        System.out.println((int)Math.abs(Long.MAX_VALUE -2));

    }
}
