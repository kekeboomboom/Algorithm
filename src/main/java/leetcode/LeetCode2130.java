package leetcode;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/8
 */
public class LeetCode2130 {

    /**
     * 首先这道题调用java的api有很多方式去做。
     * 但是既然考察的是链表，那么我们就尽可能用链表的方式去做。
     * 我的思路是，我们创建一个新链表，这条链表是原链表的反转链表，并且在做反转的过程中记录链表长度
     * 接着遍历两个链表，原链表和反转链表遍历过程中，正好就是孪生节点。而且我们只需要遍历链表一半长度即可
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        ListNode pre=null;
        ListNode cur = head;
        int len=0;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = cur.next;
            len++;
        }
        ListNode reverseList = pre;
        int maxSum=0;
        int pairNum = len / 2;
        while (pairNum > 0) {
            pairNum--;
            maxSum = Math.max(head.val + reverseList.val, maxSum);
            head = head.next;
            reverseList = reverseList.next;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode1 = new ListNode(1);
        listNode5.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode1;

        LeetCode2130 leetCode2130 = new LeetCode2130();
        leetCode2130.pairSum(listNode5);
    }
}
