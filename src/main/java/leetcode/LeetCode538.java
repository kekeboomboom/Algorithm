package leetcode;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class LeetCode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;

        convertBST(root.left);
        return root;
    }
}
