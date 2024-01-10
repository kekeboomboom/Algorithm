package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/10
 * {@code @description:}
 */
public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        dfs(root, targetSum, tmp, result);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> tmp, LinkedList<List<Integer>> result) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(tmp));
        }
        dfs(root.left, targetSum, tmp, result);
        dfs(root.right, targetSum, tmp, result);
        tmp.remove(tmp.size() - 1);
    }
}
