package NowCoder;

public class BM29 {

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        boolean leftRes = hasPathSum(root.left, sum - root.val);
        boolean rightRes = hasPathSum(root.right, sum - root.val);
        return leftRes || rightRes;
    }
}
