package NowCoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BM12 {

    // 牛客的好像不支持stream
    public ListNode sortInList (ListNode head) {
        // write code here
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        List<ListNode> sortedList = listNodes.stream().sorted(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }).collect(Collectors.toList());

        ListNode resHead = sortedList.get(0);
        ListNode cur = resHead;
        for (int i = 1; i < sortedList.size(); i++) {
            cur.next = sortedList.get(i);
            cur = cur.next;
        }
        return resHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(-1);
        head.next.next = new ListNode(6);

        BM12 bm12 = new BM12();
        bm12.sortInList(head);
    }
}
