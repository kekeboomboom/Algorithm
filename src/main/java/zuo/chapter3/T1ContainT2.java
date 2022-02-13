package zuo.chapter3;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/5/11
 */
public class T1ContainT2 {

    public boolean contains(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        // 因为t1不是一开头就跟t2匹配，所以也需要contains递归去找
        // 只要找到t1的子节点与t2相等的，则进行check递归，由于或运算只要有一个true，则结果为true
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    private boolean check(TreeNode h, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        // 此还可判断t1子节点是否与t2头结点相等呢！
        if (h == null || h.val != t2.val) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
