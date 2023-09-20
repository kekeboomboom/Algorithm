package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/20
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        int balance = balance(root);
        if (balance == -1) {
            return false;
        }
        return true;
    }

    private int balance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balance(root.left);
        int right = balance(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
}
