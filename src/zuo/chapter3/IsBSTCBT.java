package zuo.chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author keboom
 * @date 2021/5/21
 */
public class IsBSTCBT {

    // 左神使用mirrors中序遍历来做
    public boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    // 那么我不会mirrors，那么我就用普通的中序遍历来做了
    public boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.value < pre) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

    /**
     * 1．按层遍历二叉树，从每层的左边向右边依次遍历所有的节点
     * 2．如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false。
     * 3．如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回 false。
     * 4．遍历过程中如果不返回 false，则遍历结束后返回 true
     * @param head
     * @return
     */
    public boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsBSTCBT is = new IsBSTCBT();
//        Node head = Node.getBSTTree();
        Node head = Node.getTestTree();
        System.out.println(is.isBST(head));
        System.out.println(is.isBST2(head));
    }
}
