package leetcode;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class LeetCode236 {

    /**
     * 对于父节点，只有两种情况
     * 1. p 或 q 本身作为父节点
     * 2. p 或 q 需要向上找一个公共父节点
     *
     * 对于当前节点
     * 1. 本身为 p 或 q 或 null， 则直接返回当前节点
     * 2. 当前节点左 或 右节点，都找不到p 或 q，则都为null
     * 3. 当前节点 左 或 右，其中有一个p 或 q， 则返回p 或 q
     * 4. 当前节点 左 或 右，分别为 p 或 q，则返回当前节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
