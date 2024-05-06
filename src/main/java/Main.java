import common.ListNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(7 / 10);

    }


    /**
     * 虚拟头节点。cur 是遍历到的当前节点。判断下一个和下下一个节点是不是重复，如果重复，删除。得到重复节点的 val，next 指针不停往下走
     * 如果 val 等于重复节点的，则不管，直到 val 不等于重复节点。则 cur 指向 next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int duplicateVal = cur.next.val;
                ListNode next = cur.next.next;
                while (next != null && next.val == duplicateVal) {
                    next = next.next;
                }
                cur.next = next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
