import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();



    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        dummy.next = cur2;
        ListNode next = cur2.next;
        while (cur2 != null) {
            cur2.next = cur1;
            cur1.next = next;
            pre.next = cur2;
            pre = cur1;
            cur1 = next;
            if (cur1 == null) {
                break;
            }
            cur2 = cur1.next;
            if (cur2 == null) {
                break;
            }
            next = cur2.next;
        }
        return dummy.next;
    }
}
