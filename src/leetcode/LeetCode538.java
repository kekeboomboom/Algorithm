package leetcode;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class LeetCode538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = convertBST(root.right);
        if (right != null) {
            root.val = right.val + root.val;
        }
        if (root.left != null) {
            root.left.val = root.val + root.left.val;
        }
        convertBST(root.left);
        return root;
    }
}
