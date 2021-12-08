import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import leetcode.TreeNode;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
