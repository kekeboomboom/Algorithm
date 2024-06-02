package leetcode;

import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/5/22
 */
public class LeetCode117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre=null;
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    pre.next = null;
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
