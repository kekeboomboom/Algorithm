package zuo.chapter2;

/**
 * 反转链表
 * @author keboom
 * @date 2021/6/8
 */
public class Reverse {


    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
