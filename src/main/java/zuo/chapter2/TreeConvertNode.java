package zuo.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 搜索二叉树转换为双向链表
 * @author keboom
 * @date 2021/6/11
 */
public class TreeConvertNode {

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }



    /**
     * 将中序遍历的结果放入队列，然后从队列依次取出，组成链表
     * @param head
     * @return
     */
    public DoubleNode convert1(Node head) {
        LinkedList<Node> queue = new LinkedList<>();
//        inorderToqueue(head, queue);

        return null;
    }


    // 递归形式

    public class RetrunType {
        public Node start;
        public Node end;

        public RetrunType(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }


    public RetrunType process(Node head) {
        if (head == null) {
            return new RetrunType(null, null);
        }
        RetrunType leftList = process(head.left);
        RetrunType rightList = process(head.right);
        if (leftList.end != null) {
            leftList.end.right = head;
        }
        head.left = leftList.end;
        head.right = rightList.start;
        if (rightList.start != null) {
            rightList.start.left = head;
        }
        return new RetrunType(leftList.start != null ? leftList.start : head,
                rightList.end != null ? rightList.end : head);
    }
}
