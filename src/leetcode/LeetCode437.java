package leetcode;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode437 {

    /**
     * 通过前缀和，map来记录遍历过的所有种类的和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return process(root, targetSum, map, 0);
    }

    private int process(TreeNode root, int targetSum, HashMap<Integer, Integer> map, int curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;
        res += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += process(root.left, targetSum, map, curSum);
        res += process(root.right, targetSum, map, curSum);

        map.put(curSum, map.get(curSum) - 1);
        return res;
    }


}
