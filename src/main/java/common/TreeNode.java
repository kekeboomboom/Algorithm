package common;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author keboom
 * @date 2021/4/30
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 这是一个二叉搜索树
     *          10
     *     5          15
     *  4     7    12    18
     * @return
     */
    public static TreeNode getBSTTree() {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode18 = new TreeNode(18);

        treeNode10.left = treeNode5;
        treeNode10.right = treeNode15;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode7;
        treeNode15.left = treeNode12;
        treeNode15.right = treeNode18;

        return treeNode10;
    }

    public void preOrderUnRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void InOrderUnRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
    }

    public static void PosOrderUnRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                System.out.print(node.val+" ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode.level(getBSTTree());
    }
}
