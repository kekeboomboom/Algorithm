package leetcode;

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/29
 */
public class LeetCode450 {

    /**
     * 先找到相应的位置，然后将原来的节点删掉，将原来的节点的左节点替换上去。
     * 替换的节点的左子树不变，右子树放到原来节点的右节点的最左边
     *
     *                      100
     *           9                        150
     *       5      20               125        175
     *   2     7  15    25
     *
     * 删除9
     *
     *                         100
     *          5                         150
     *      2          20                 125       175
     *              15    25
     *            7
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left != null) {
                TreeNode delLeft = root.left;
                TreeNode delRight = root.right;
                root = delLeft;
                TreeNode delLeftRightestNode = delLeft.right;
                if (delLeftRightestNode == null) {
                    delLeft.right = delRight;
                } else {
                    while (delLeftRightestNode.right != null) {
                        delLeftRightestNode = delLeftRightestNode.right;
                    }
                    delLeftRightestNode.right = delRight;
                }
            } else {
                root = root.right;
            }
            return root;
        }
        deleteNode2(root, key);
        return root;
    }

    private void deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val == key) {
            if (root.left.left != null) {
                TreeNode delRight = root.left.right;
                TreeNode delLeft = root.left.left;
                root.left = delLeft;
                TreeNode delLeftRightestNode = delLeft.right;
                if (delLeftRightestNode == null) {
                    delLeft.right = delRight;
                } else {
                    while (delLeftRightestNode.right != null) {
                        delLeftRightestNode = delLeftRightestNode.right;
                    }
                    delLeftRightestNode.right = delRight;
                }
            } else {
                root.left = root.left.right;
            }
            return;
        }
        if (root.right != null && root.right.val == key) {
            if (root.right.left != null) {
                TreeNode delRight = root.right.right;
                TreeNode delLeft = root.right.left;
                root.right = delLeft;
                TreeNode delLeftRightestNode = delLeft.right;
                if (delLeftRightestNode == null) {
                    delLeft.right = delRight;
                } else {
                    while (delLeftRightestNode.right != null) {
                        delLeftRightestNode = delLeftRightestNode.right;
                    }
                    delLeftRightestNode.right = delRight;
                }
            } else {
                root.right = root.right.right;
            }
            return;
        }
        if (root.val > key) {
            deleteNode2(root.left, key);
        }
        if (root.val < key) {
            deleteNode2(root.right, key);
        }
    }
}
