package SwordPointToOffer;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer55 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, 0);
    }

    private int process(TreeNode root, int h) {
        if (root == null) {
            return h;
        }
        return Math.max(process(root.left, h + 1), process(root.right, h + 1));
    }
}
