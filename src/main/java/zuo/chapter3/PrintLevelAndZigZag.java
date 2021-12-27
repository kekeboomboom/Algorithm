package zuo.chapter3;

import common.TreeNode;
import java.util.*;

/**
 * @author keboom
 * @date 2021/5/11
 */
public class PrintLevelAndZigZag {


    /**
     * 这个题在层序遍历的基础上，添加了打印当前层数的要求
     * 每当我们遍历完当前层的同时，我们也就把下一层的所有元素都放到队列里了
     * 所以我们通过last和nLast这两个变量巧妙的标识了每一层的最后一个元素！
     * @param head
     */
    public void printByLevel(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        queue.offer(head);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " +(level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }



    /**
     * 维护一个队列，如果是奇数level，则前出后进，并且是先左节点后右节点
     * 如果是偶数level，则后出前进，并且是先右节点后左节点
     * 如果遍历到last则说明该换下一行了
     * @param head
     */
    public void printByZigZag(TreeNode head) {
        if (head == null) {
            return;
        }
        Deque<TreeNode> dp = new LinkedList<>();
        int level = 1;
        boolean lr = true;
        TreeNode last = head;
        TreeNode nLast = null;
        dp.offerFirst(head);
        printLevelAndOrientation(level++, lr);
        while (!dp.isEmpty()) {
            if (lr) {
                head = dp.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dp.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerLast(head.right);
                }
            } else {
                head = dp.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dp.offerFirst(head.left);
                }
            }
            System.out.println(head.value + " ");
            if (head == last && !dp.isEmpty()) {
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++, lr);
            }
        }
    }

    private void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level " + level + " from ");
        System.out.print(lr ? "left to right: " : "right to left");
    }


    /**
     * z形打印二叉树，放到list中
     * @param head
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode last = head;
        TreeNode nLast = null;
        boolean lr = true;
        dq.offerFirst(head);
        while (!dq.isEmpty()) {
            if (lr) {
                head = dq.pollFirst();
                if (head.left != null) {
                    dq.offerLast(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
                if (head.right != null) {
                    dq.offerLast(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
            } else {
                head = dq.pollLast();
                if (head.right != null) {
                    dq.offerFirst(head.right);
                    nLast = nLast == null ? head.right : nLast;
                }
                if (head.left != null) {
                    dq.offerFirst(head.left);
                    nLast = nLast == null ? head.left : nLast;
                }
            }
            tmp.add(head.value);
            if (head == last) {
                lr = !lr;
                last = nLast;
                nLast = null;
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }

        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.value);
                } else {
                    tmp.addFirst(node.value);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

//    public static void main(String[] args) {
//        List<List<Integer>> lists = exc.levelOrder2(TreeNode.getTestTree());
//        System.out.println(lists.size());
//        for (int i = 0; i < lists.size(); i++) {
//            List<Integer> list = lists.get(i);
//            System.out.println();
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//        }
//    }


}
