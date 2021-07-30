package leetcode;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode19 {

    /**
     * 这题我们用pre，cur来维持一个大小固定为n距离的窗口，
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        int k = 0;
        while (cur != null) {
            k++;
            cur = cur.next;
            if (k > n) {
                pre = pre.next;
            }
            if (cur == null) {
                pre.next = pre.next.next;
            }
        }
        if (pre.val == -1) {
            return pre.next;
        }
        return head;
    }
}
