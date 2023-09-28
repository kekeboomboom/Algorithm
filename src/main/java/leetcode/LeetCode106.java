package leetcode;

import java.util.HashMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/26
 */
public class LeetCode106 {

    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootInorderIndex = inorderMap.get(postorder[postEnd]);
        root.left = buildTree(inorder, inStart, rootInorderIndex - 1, postorder, postStart, postStart + rootInorderIndex - inStart - 1);
        root.right = buildTree(inorder, rootInorderIndex + 1, inEnd, postorder, postEnd - inEnd + rootInorderIndex, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {

    }
}
