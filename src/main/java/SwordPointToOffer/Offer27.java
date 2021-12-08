package SwordPointToOffer;

import leetcode.TreeNode;

/**
 * @author keboom
 * @date 2021/3/15
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        //空指针异常！！
//        if (root.left == null && root.right == null) {
//            return root;
//        }
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        return root;

        //if终止条件应该去判断当前层次的root，
        // 而不是判断下一层次的，比如root.left就相当于null.left当然会报空指针异常
        if (root==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }


}
