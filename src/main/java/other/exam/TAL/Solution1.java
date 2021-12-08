package other.exam.TAL;

/**
 * @author keboom
 * @date 2021/8/8
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }

    }


    public static void main(String[] args) {

    }
}

/*
{1,3,4},{2,5,6}

{1,2,3,4,5,6}

 */
