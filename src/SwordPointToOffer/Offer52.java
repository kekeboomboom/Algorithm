package SwordPointToOffer;

import leetcode.ListNode;

import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedList<ListNode> stackA = new LinkedList<>();
        LinkedList<ListNode> stackB = new LinkedList<>();
        ListNode curA = headA,curB=headB;
        while (curA != null) {
            stackA.push(curA);
            curA = curA.next;
        }
        while (curB != null) {
            stackB.push(curB);
            curB = curB.next;
        }
        if (stackA.peek() != stackB.peek()) {
            return null;
        }
        ListNode comNode = null;
        while (stackA.peek() == stackB.peek()) {
            comNode = stackA.poll();
            stackB.poll();
        }
        return comNode;
    }
}
