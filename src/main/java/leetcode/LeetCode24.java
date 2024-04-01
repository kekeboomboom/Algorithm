package leetcode;

import common.ListNode;

/**
 * @author keboom
 * @date 2021/3/4
 *
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next; // 注意返回的是next，而不是head，因为交换后头结点变了

    }


    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        dummy.next = cur2;
        ListNode next = cur2.next;
        while (cur2 != null) {
            cur2.next = cur1;
            cur1.next = next;
            pre.next = cur2;
            pre = cur1;
            cur1 = next;
            if (cur1 == null) {
                break;
            }
            cur2 = cur1.next;
            if (cur2 == null) {
                break;
            }
            next = cur2.next;
        }
        return dummy.next;
    }
}
