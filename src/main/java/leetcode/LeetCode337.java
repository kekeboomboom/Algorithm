package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author keboom
 * @date 2021/8/3
 */
public class LeetCode337 {

    /*
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        int res = Math.max(money, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }

     */

    public int rob(TreeNode root) {
        int[] result = process(root);
        return Math.max(result[0], result[1]);
    }

    private int[] process(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = process(root.left);
        int[] right = process(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
