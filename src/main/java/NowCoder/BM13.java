package NowCoder;

import java.util.ArrayList;

public class BM13 {

    public boolean isPail (ListNode head) {
        // write code here
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            if (array.get(left) != array.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        int a = -401261;
        int b = -401261;

        System.out.println(a != b);
    }
}
