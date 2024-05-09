package leetcode;

import common.ListNode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/9
 * {@code @description:}
 */
public class LeetCode86 {

    /**
     * 如果是数组，那么我们会用双指针，在原数组上做交换即可。
     * 但是对于链表，做节点的交换挺麻烦的
     * 题解给出的，直接生成新联表做法很简单，小于的生成一个链表，大于的生成一个链表，代码编写起来容易些
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode smallCur = smallHead;
        ListNode bigHead = new ListNode();
        ListNode bigCur = bigHead;
        while (head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                bigCur.next = head;
                bigCur = bigCur.next;
            }
            head = head.next;
        }
        smallCur.next = bigHead.next;
        bigCur.next = null;
        return smallHead.next;
    }
}
