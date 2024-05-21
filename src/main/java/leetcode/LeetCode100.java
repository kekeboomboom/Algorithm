package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/5/21
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            if (p.val == q.val) {
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            } else {
                return false;
            }
        }

    }
}
