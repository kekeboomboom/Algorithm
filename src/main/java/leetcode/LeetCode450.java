package leetcode;

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/29
 */
public class LeetCode450 {

    /**
     * 总体思路，如删除当前节点，则左子树补上来，右子树放在左子树的最右边
     * <p>
     * 具体细节：
     * 如果左子树存在，右子树不存在：直接将左子树补上来即可
     * 左有，右有：左补上来，右放在左的最右边
     * 左无，右有：右补上来
     * 左无，右无：删除当前节点后什么也不做
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                return root.left;
            }
        }
        return root;
    }
}
