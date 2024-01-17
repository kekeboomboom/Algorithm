import common.ListNode;
import leetcode.TreeNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(null != null);


    }


    public void flatten(TreeNode root) {
        process(root);
    }

    /**
     * 为了方便理解，我就多定义了几个变量
     * @param root
     * @return
     */
    private TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode originLeft = root.left;
        TreeNode originRight = root.right;
        if (originLeft != null) {
            root.right = root.left;
            root.left = null;
        }
        TreeNode left = process(originLeft);
        TreeNode right = process(originRight);
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }

}
