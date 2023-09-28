package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/26
 */
public class LeetCode112 {

    /**
     * if cur targetSum is 0.and cur node is leaf node.then return true.
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
