package SwordPointToOffer;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer54 {

    int m = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        process(root, k);
        return res;
    }

    private void process(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        process(root.right, k);
        m++;
        if (m == k) {
            res = root.val;
            return;
        }
        process(root.left,k);
    }
}
