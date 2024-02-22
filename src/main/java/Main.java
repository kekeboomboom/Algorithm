import common.ListNode;
import common.TreeNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 1, 1, 1, 1};

    }

    public int rob(TreeNode root) {
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
