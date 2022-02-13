package zuo.chapter3;

import common.TreeNode;
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
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 先序遍历反序列化
     * @param preStr
     * @return
     */
    public TreeNode reconByPreString(String preStr) {
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
    private TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    /**
     * 层序遍历来序列化
     * @param head
     * @return
     */
    public String serialByLevel(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.val + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.val + "!";
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
    public TreeNode reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        TreeNode treeNode = null;
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            treeNode.left = generateNodeByString(values[index++]);
            treeNode.right = generateNodeByString(values[index++]);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return head;
    }

    private TreeNode generateNodeByString(String val) {
        if ("#".equals(val)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}
