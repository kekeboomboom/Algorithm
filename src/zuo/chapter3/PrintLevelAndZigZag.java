package zuo.chapter3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author keboom
 * @date 2021/5/11
 */
public class PrintLevelAndZigZag {


    /**
     * 这个题在层序遍历的基础上，添加了打印当前层数的要求
     * 每当我们遍历完当前层的同时，我们也就把下一层的所有元素都放到队列里了
     * 所以我们通过last和nLast这两个变量巧妙的标识了每一层的最后一个元素！
     * @param head
     */
    public void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = head;
        Node nLast = null;
        queue.offer(head);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " +(level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }



    /**
     * 维护一个队列，如果是奇数level，则前出后进，并且是先左节点后右节点
     * 如果是偶数level，则后出前进，并且是先右节点后左节点
     * 如果遍历到last则说明该换下一行了
     * @param head
     */
    public void printByZigZag(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> dp = new LinkedList<>();
        int level = 1;
        boolean lr = true;
        Node last = head;
        Node nLast = null;
        dp.offerFirst(head);
        printLevelAndOrientation(level++, lr);
        while (!dp.isEmpty()) {
            if (lr) {
                head = dp.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dp.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerLast(head.right);
                }
            } else {
                head = dp.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dp.offerFirst(head.left);
                }
            }
            System.out.println(head.value + " ");
            if (head == last && !dp.isEmpty()) {
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++, lr);
            }
        }
    }

    private void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level " + level + " from ");
        System.out.print(lr ? "left to right: " : "right to left");
    }



}
