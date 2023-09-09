package leetcode;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/8
 */
public class LeetCode328 {

    /**
     * 创建两个链表，一个为奇数，一个为偶数
     * 最终进行合并。奇数链表的尾部和偶数链表的头部
     * 初始判断，链表长度为0、1、2的，直接返回head
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
