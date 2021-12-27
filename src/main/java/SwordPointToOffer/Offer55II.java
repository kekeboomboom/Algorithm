package SwordPointToOffer;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer55II {

    public boolean isBalanced(TreeNode root) {
        return process(root) == -1 ? false : true;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        if (left == -1) {
            return -1;
        }
        int right = process(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
