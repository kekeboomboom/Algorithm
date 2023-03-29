package NowCoder;

import java.util.ArrayList;

public class BM5 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divMerge(lists, 0, lists.size() - 1);
    }

    private ListNode divMerge(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return lists.get(left);
        }
        int mid = (right+left)/2;
        ListNode leftNode = divMerge(lists, left, mid);
        ListNode rightNode = divMerge(lists, mid + 1, right);
        return Merge(leftNode, rightNode);
    }

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
