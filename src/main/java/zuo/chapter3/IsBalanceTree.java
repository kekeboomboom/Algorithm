package zuo.chapter3;

/**
 * 树形dp套路
 * @author keboom
 * @date 2021/5/17
 */
public class IsBalanceTree {
    class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    private ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
