package leetcode;

/**
 * @author keboom
 * @date 2021/7/29
 */
public class LeetCode141 {

    /**
     * 常规解法那就是用hashmap，判断节点值是否遍历过，但是这样空间复杂度为o（n）
     * 我们用快慢指针，一个乌龟，一个兔子，兔子跑得快，如果有环的话，两者迟早相遇
     *
     * 关于链表和数组的讲解：https://leetcode-cn.com/problems/linked-list-cycle/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (slow == fast && slow != null && fast != null) {
                return true;
            }
        }
        return false;
    }
}
