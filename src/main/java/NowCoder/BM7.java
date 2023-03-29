package NowCoder;

public class BM7 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cur = dummy;
                while (cur != slow) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return cur;
            }
        }
        return null;
    }
}
