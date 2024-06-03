package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/6/3
 */
public class LeetCode124 {

    private int maximumSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maximumSum;
    }

    /**
     * 找到当前节点左子树，和右子树最大路径和。如果最大路径和都小于 0，那么就不选择此子树
     * @param root
     * @return
     */
    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);
        int curSum = left + right + root.val;
        maximumSum = Math.max(maximumSum, curSum);
        return root.val + Math.max(left, right);
    }
}
