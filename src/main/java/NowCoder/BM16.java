package NowCoder;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BM16 {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode follow = cur.next;
        ListNode tmp;

        while (follow != null) {
            if (cur.val == follow.val) {
                while (cur.val == follow.val) {
                    follow = follow.next;
                    cur.next = follow;
                }
                cur = follow;
                follow = follow.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
                follow= follow.next;
            }
        }
        return dummy.next;
    }


}
