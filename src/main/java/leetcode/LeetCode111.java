package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/20
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (leftMin == 0) {
            return rightMin+1;
        } else if (rightMin == 0) {
            return leftMin + 1;
        } else {
            return Math.min(leftMin, rightMin) + 1;
        }
    }
}
