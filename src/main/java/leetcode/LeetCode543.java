package leetcode;

/**
 * @author keboom
 * @date 2021/7/31
 */
public class LeetCode543 {

    // 我们用一个变量记录最终结果
    int res = 0;

    /**
     * 首先这题并不是我们想象中的左右子树高度一加就完事了。是有可能最远距离仅仅在左子树或者右子树。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return res;
    }

    /**
     * 此函数返回值为此节点左右子树中的最高高度
     * @param root
     * @return
     */
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        res = Math.max(left + right, res);
        return Math.max(left,right) + 1;
    }
}
