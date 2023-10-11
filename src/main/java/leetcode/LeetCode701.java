package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/29
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.left;
                }
            } else{ // 题目保证新插入点，不与袁二叉树任何节点相等，因此不是大于就是小于
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
}
