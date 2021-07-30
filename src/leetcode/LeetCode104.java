package leetcode;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxHeight(root, 0);
    }

    private int maxHeight(TreeNode root, int h) {
        if (root == null) {
            return h;
        }
        return Math.max(maxHeight(root.left, h + 1), maxHeight(root.right, h + 1));
    }
}
