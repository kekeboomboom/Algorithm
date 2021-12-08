package leetcode;

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






//        if (head==null || head.next==null){
//            return head;
//        }
//        else {
//            ListNode tmp = head.next.next;
//            head.next.next = head;
//            head.next = tmp;
//            return swapPairs(head.next);
//        }

//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
//        return next;
    }

}
