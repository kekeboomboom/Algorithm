package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/28
 */
public class LeetCode501 {

    int maxCount=0;
    int curCount=0;
    int curVal = Integer.MIN_VALUE;
    LinkedList<Integer> result = new LinkedList<>();
    public int[] findMode(TreeNode root) {
        findMode2(root);
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.pop();
        }
        return ints;
    }

    private void findMode2(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode2(root.left);
        if (curVal == Integer.MIN_VALUE) {
            curVal = root.val;
            curCount++;
            result.add(curVal);
            maxCount = 1;
        } else if (curVal == root.val) {
            curCount++;
            if (curCount == maxCount) {
                result.add(curVal);
            } else if (curCount > maxCount) {
                result = new LinkedList<>();
                result.add(curVal);
                maxCount = curCount;
            }
        } else {
            if (curCount == maxCount) {
                result.add(curVal);
            } else if (curCount > maxCount) {
                result = new LinkedList<>();
                result.add(curVal);
            }
            curCount = 1;
            curVal = root.val;
        }
        findMode2(root.right);
    }
}
