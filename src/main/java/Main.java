import common.ListNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        main.rotateRight(listNode1, 2);
    }


    /**
     * 倒置后 k 个链表，
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next ==null) {
            return head;
        }
        int len = getLen(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode kLast = findKLast(head, k);
        ListNode newHead = kLast.next;
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        kLast.next = null;
        return newHead;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 返回倒数第 k + 1 个节点
     *
     * @param head
     * @return
     */
    private ListNode findKLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k >= 0) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
