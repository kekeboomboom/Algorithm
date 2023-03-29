package NowCoder;

public class BM8 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode pre = pHead;
        ListNode cur = pHead;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }
}
