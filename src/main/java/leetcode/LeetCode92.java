package leetcode;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/5/8
 */
public class LeetCode92 {

    /**
     * 这道题目我们能想到就是，知道需要做反转的一小段，然后做反转，然后重新连接得到的结果。
     * 还有一种更好的方法，头插法。比如我要将 3--9--2 反转。那么头插法过程：
     * 9--3--2
     * 2--9--3
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 我们先找到 left，就是要反转的头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        int headStep = 1;
        ListNode headLeft=head;
        while (headStep < left) {
            headStep++;
            headLeft = headLeft.next;
            pre = pre.next;
        }
        pre.next = reverseList(headLeft,right-left+1);
        return dummy.next;
    }

    /**
     * 头插法，倒置链表
     * @param head
     * @param len 需要倒置的链表长度
     * @return
     */
    private ListNode reverseList(ListNode head,int len) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        ListNode pre = head;
        while (cur != null && len >1) {
            len--;
            next = cur.next;
            pre.next = next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
}
