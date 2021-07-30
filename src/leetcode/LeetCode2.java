package leetcode;

import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int sum = value1 + value2 + carry;
            carry = sum / 10;
            int value = sum % 10;

            cur.next= new ListNode(value);

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}
