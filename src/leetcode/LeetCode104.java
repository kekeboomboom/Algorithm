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
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;













//        if (root == null) {
//            return 0;
//        } else {
//            int leftHeight = maxDepth(root.left);
//            int rightHeight = maxDepth(root.right);
//            return Math.max(leftHeight, rightHeight) + 1;
//        }
    }
}
