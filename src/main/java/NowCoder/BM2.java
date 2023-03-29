package NowCoder;

public class BM2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode tmp;
        for (int i = 0; i < n - m; i++) {
            tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;

    }

}
