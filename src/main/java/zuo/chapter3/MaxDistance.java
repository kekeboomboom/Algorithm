package zuo.chapter3;

import common.TreeNode;

/**
 * 求二叉树中两节点的最大距离
 * @author keboom
 * @date 2021/5/21
 */
public class MaxDistance {

    public class ReturnType {
        public int maxDistance;
        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public int getMaxDistance(TreeNode head) {
        return process(head).maxDistance;
    }

    private ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(leftData.height + rightData.height + 1,
                Math.max(leftData.maxDistance, rightData.maxDistance));
        return new ReturnType(maxDistance, height);
    }
}
