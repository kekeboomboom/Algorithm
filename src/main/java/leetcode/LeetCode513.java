package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/25
 */
public class LeetCode513 {

    /**
     * recursion is hard. but traversal sequence is easy
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftVal=0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if (i == 0) {
                    leftVal = remove.val;
                }
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
        }
        return leftVal;
    }
}
