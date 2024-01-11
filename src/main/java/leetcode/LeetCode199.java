package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/11
 * {@code @description:}
 */
public class LeetCode199 {

    /**
     * 只需在层序遍历时，取队列的最右边的值即可
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>(levelNodeNum);
            for (int i = 0; i < levelNodeNum; i++) {
                TreeNode remove = queue.remove();
                tmp.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            result.add(tmp.get(tmp.size() - 1));
        }
        return result;
    }


    /**
     * 这是层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>(levelNodeNum);
            for (int i = 0; i < levelNodeNum; i++) {
                TreeNode remove = queue.remove();
                tmp.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
