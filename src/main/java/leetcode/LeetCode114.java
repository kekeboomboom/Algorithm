package leetcode;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode node = root;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = tmp;
            }
            root = root.right;
        }
    }



    // me method
    public void flatten2(TreeNode root) {
        process(root);
    }

    private TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = process(root.right);
        root.right = process(root.left);
        root.left = null;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = tmp;
        return root;
    }
}
