package SwordPointToOffer;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/9
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }
}
