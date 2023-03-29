package NowCoder;

import java.util.LinkedList;

public class BM11 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        LinkedList<ListNode> resStack = new LinkedList<>();
        int carry=0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = stack1.isEmpty()?0:stack1.pop().val;
            int val2 = stack2.isEmpty()?0:stack2.pop().val;
            int sum = val1+val2+carry;
            if (sum < 10) {
                resStack.push(new ListNode(sum));
                carry=0;
            } else {
                resStack.push(new ListNode(sum - 10));
                carry=1;
            }
        }
        if (carry == 1) {
            resStack.push(new ListNode(1));
        }
        ListNode head = resStack.pop();
        ListNode cur = head;
        while (!resStack.isEmpty()) {
            cur.next = resStack.pop();
            cur = cur.next;
        }
        return head;
    }
}
