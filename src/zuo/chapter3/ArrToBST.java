package zuo.chapter3;

/**
 * 给定一个有序数组 sortArr，已知其中没有重复值，用这个有序数组生成一棵平衡搜索二叉
 * 树，并且该搜索二叉树中序遍历的结果与 sortArr 一致
 * @author keboom
 * @date 2021/5/21
 */
public class ArrToBST {

    /**
     * @param sortArr
     * @return
     */
    public Node generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    private Node generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }
}
