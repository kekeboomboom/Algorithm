package NowCoder;

public class BM4 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1 == null && list2 == null) {
            return dummy.next;
        } else if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }
}
