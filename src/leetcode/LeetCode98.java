package leetcode;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode98 {

    public int pre = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
