package NowCoder;

public class BM9 {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        for (int i = 0; i < n + 1; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
