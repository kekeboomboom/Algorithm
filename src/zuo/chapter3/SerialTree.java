package zuo.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author keboom
 * @date 2021/5/6
 */
public class SerialTree {

    /**
     * 通过先序遍历来序列化
     * @param head
     * @return
     */
    public String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 先序遍历反序列化
     * @param preStr
     * @return
     */
    public Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    /**
     * 正好模拟了先序遍历的过程
     * @param queue
     * @return
     */
    private Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    /**
     * 层序遍历来序列化
     * @param head
     * @return
     */
    public String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }


    /**
     * 反序列化--层遍历
     * @param levelStr
     * @return
     */
    public Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    private Node generateNodeByString(String val) {
        if ("#".equals(val)) {
            return null;
        }
        return new Node(Integer.parseInt(val));
    }
}
