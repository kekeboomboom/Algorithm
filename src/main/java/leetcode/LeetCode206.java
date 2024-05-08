package leetcode;

import common.ListNode;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 我们试着用头插法，做一次
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        ListNode pre = head;
        while (cur != null) {
            next = cur.next;
            pre.next = next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
}
