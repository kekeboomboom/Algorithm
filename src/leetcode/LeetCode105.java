package leetcode;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/7/28
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,map);
    }

    private TreeNode process(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj,HashMap<Integer, Integer> map) {
        if (prei > prej) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[prei]);
        Integer h_inorder_index = map.get(preorder[prei]);
        int leftLen = h_inorder_index - ini;
        int rightLen = inj - h_inorder_index;
        head.left = process(preorder, prei + 1, prei + leftLen, inorder, ini, ini + leftLen-1,map);
        head.right = process(preorder, prej - rightLen + 1, prej, inorder, inj - rightLen + 1, inj,map);
        return head;
    }
}
