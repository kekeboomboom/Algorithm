import common.ListNode;

import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();



    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addNums(l1, l2, 0);
    }

    private ListNode addNums(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0) {
                ListNode addNode = new ListNode(carry);
                return addNode;
            }
        } else if (l1 == null && l2 != null) {
            ListNode addNode = new ListNode((l2.val+carry)%10);
            addNode.next = addNums()
        }else if (l2)
    }

}
