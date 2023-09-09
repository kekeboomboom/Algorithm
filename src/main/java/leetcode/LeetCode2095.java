package leetcode;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/7
 */
public class LeetCode2095 {

    /**
     * 快慢指针，一个每次走一步，一个每次走两步
     * 创建虚拟节点，作为头结点。快慢节点从虚拟节点出发
     * 如果快节点的下一个节点或者下下一个节点为null，那么此时准备删除慢节点的下一个节点
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow=dummy,fast=dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
