package leetcode;

import common.ListNode;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class LeetCode160 {

    /**
     * 简单的我们用hashset<ListNode>就能解决了
     *
     * 但是我们看看更巧妙的方法，
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
