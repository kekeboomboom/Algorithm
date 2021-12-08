package zuo.chapter2;

/**
 * 打印有序链表公共部分
 * @author keboom
 * @date 2021/6/8
 */
public class PrintCommon {
    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
