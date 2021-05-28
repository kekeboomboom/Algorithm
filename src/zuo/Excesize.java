package zuo;

import zuo.chapter3.Node;
import zuo.chapter3.PrintTree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author keboom
 * @date 2021/4/28
 */
public class Excesize {


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
     *          10
     *      12        15
     *   4     7    5    18
     */
    public static void main(String[] args) {
        Excesize exc = new Excesize();
        Node head = Node.getTestTree();
//        Node bstTree = Node.getBSTTree();
        System.out.println(exc.serialByLevel(head));
    }
}
