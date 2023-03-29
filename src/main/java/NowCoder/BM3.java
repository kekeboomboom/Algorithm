package NowCoder;

public class BM3 {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int length=0;
        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++) {
            ListNode tmp;
            for (int j = 0; j < k-1; j++) {
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
