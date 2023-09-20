package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/9
 */
public class LeetCodeTest {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
