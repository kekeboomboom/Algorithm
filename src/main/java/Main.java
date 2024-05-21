import common.ListNode;
import common.TreeNode;


/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();


    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if ((left == null && right != null) && (left != null && right == null)) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return symmetric(left.left, right.right) && symmetric(left.right, right.left);
            }
        }
    }
}
