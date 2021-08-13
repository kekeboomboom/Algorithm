package leetcode;

/**
 * @author keboom
 * @date 2021/8/13
 */
public class LeetCode61 {

    /**
     * 先获得链表长度，对k取余，寻找倒数第k+1个节点，切断之，然后头尾节点相连。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int k2 = k % len;
        if (len == 1 || k2 == 0) {
            return head;
        }
        cur = head;
        ListNode pre = head;
        ListNode newHead = null;
        int j = 0;
        while (cur != null) {
            if (j <= k2) {
                j++;
            } else {
                pre = pre.next;
            }
            if (cur.next == null) {
                newHead = pre.next;
                pre.next = null;
                cur.next = head;
                break;
            } else {
                cur = cur.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int k = 2;
        new LeetCode61().rotateRight(head, k);
    }
}
