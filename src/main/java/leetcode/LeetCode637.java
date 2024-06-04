package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/6/4
 */
public class LeetCode637 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            double avg = levelList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            result.add(avg);
        }
        return result;
    }
}
