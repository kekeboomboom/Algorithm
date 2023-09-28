package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/21
 */
public class LeetCode257 {

    List<String> result = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        path(root, new LinkedList<Integer>());
        return result;
    }

    private void path(TreeNode root, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(tmp.stream().map(String::valueOf).collect(Collectors.joining("->")));
            tmp.remove(tmp.size() - 1);
            return;
        }
        path(root.left, tmp);
        path(root.right, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
