package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/20
 */
public class LeetCode222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
