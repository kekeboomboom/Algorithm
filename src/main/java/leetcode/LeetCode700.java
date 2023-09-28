package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/28
 */
public class LeetCode700 {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
