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

    // 思路，不管是线性，圆圈，还是树形，dp的递推公式思想都是一样的。
    // 取当前值时，那么相邻的则不可取，那么我们取 i-2 即可
    // 不取当前值时，那么相邻的可取，那么取 i-1 即可
    // 最终比较取和不取，哪个值最大
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = rob(root.left);
        int right = rob(root.right);
        // 使用当前节点的值
        int useCur = root.val;
        if (root.left != null) {
            useCur += root.left.left == null ? 0 : root.left.left.val;
            useCur += root.left.right == null ? 0 : root.left.right.val;
        }
        if (root.right != null) {
            useCur += root.right.left == null ? 0 : root.right.left.val;
            useCur += root.right.right == null ? 0 : root.right.right.val;
        }
        // 不使用当前节点
        int notUseCur = 0;
        notUseCur = left + right;

        root.val = Math.max(useCur, notUseCur);
        return root.val;
    }
}
