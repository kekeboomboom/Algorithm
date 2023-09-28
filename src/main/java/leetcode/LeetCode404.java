package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/25
 */
public class LeetCode404 {

    /**
     * we only check cur node have left sub node
     * and this left sub node is leaf node. then add is val to result.
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
