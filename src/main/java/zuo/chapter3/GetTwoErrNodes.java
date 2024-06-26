package zuo.chapter3;

import common.TreeNode;
import java.util.Stack;

/**
 * @author keboom
 * @date 2021/5/11
 */
public class GetTwoErrNodes {

    /* 我以为是相邻的父子节点交换，而实际上是任意两个节点交换
    public static Node[] getTwoErrNodes(Node head) {
        Node[] errNodes = new Node[2];
        if (head == null) {
            return errNodes;
        }
        process(head, errNodes);
        return errNodes;
    }

    private static void process(Node head, Node[] errNodes) {
        if (head == null || errNodes[0] != null) {
            return;
        }
        if (head.left != null && head.left.value > head.value) {
            errNodes[0] = head;
            errNodes[1] = head.left;
            return;
        }
        if (head.right != null && head.right.value < head.value) {
            errNodes[0] = head;
            errNodes[1] = head.right;
            return;
        }
        process(head.left, errNodes);
        process(head.right, errNodes);
    }
     */


    public static TreeNode[] getTwoErrNodes2(TreeNode head) {
        TreeNode[] errs = new TreeNode[2];
        if (head == null) {
            return errs;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.val > head.val) {
                    // 如果errs[0]为null则说明第一次进来，并且如果整个树只进来一次的话
                    // 就说明是相邻父子节点交换，如果进来第二次，则说明两错误节点不相邻
                    // 数组第一个值不更新，只更新第二个
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }


}
