package zuo.chapter3;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/4/30
 */
public class PrintEdgeNode {

    /**
     * 第一种标准打印树，获得树高，填写edgemap二维表，
     * 将每一层左右边缘部分放入表中。
     * 打印叶节点但不是边缘节点
     * @param head
     */
    public void printEdge1(TreeNode head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head, 0, edgeMap);
        for (int i = 0; i != edgeMap.length; i++) {
            System.out.println(edgeMap[i][0].value + " ");
        }
        printLeafNotInMap(head, 0, edgeMap);
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1].value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 打印不是边缘节点的叶节点
     * @param h
     * @param l
     * @param m
     */
    private void printLeafNotInMap(TreeNode h, int l, TreeNode[][] m) {
        if (h == null) {
            return;
        }
        // 首先要是叶子结点，并且不是左右边缘
        if (h.left == null && h.right == null && h != m[l][0] && h != m[l][1]) {
            System.out.println(h.value + " ");
        }
        printLeafNotInMap(h.left, l + 1, m);
        printLeafNotInMap(h.right, l + 1, m);
    }

    /**
     * edgeMap是一个二维数组，记录树的每一层最左和最右边缘节点。
     * @param h
     * @param l
     * @param edgeMap
     */
    private void setEdgeMap(TreeNode h, int l, TreeNode[][] edgeMap) {
        if (h == null) {
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }

    /**
     * 获得二叉树的高度
     * 通过不断向下递归查找，找到最大高度
     * @param head
     * @param height
     * @return
     */
    private int getHeight(TreeNode head, int height) {
        if (head == null) {
            return height;
        }
        return Math.max(getHeight(head.left, height + 1), getHeight(head.right, height + 1));
    }


    /**
     * 第二种打印标准，从头结点开始如果找不到一个有左右子节点的节点，则一直向下打印，直到找到后，
     * 则开始从此节点依次打印左边缘，右边缘
     * @param head
     */
    public void printEdge2(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true);
            printRightEdge(head.left, true);
        } else {
            printEdge2(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    /**
     * 打印叶节点和树右边界延伸下去的路径
     * 对于打印右边界我们需要先递归到最下面，然后才打印，右节点必打印。
     * 左节点在右节点没有的情况下或者左节点为叶节点时才打印
     * @param h
     * @param print
     */
    private void printRightEdge(TreeNode h, boolean print) {
        if (h == null) {
            return;
        }
        printRightEdge(h.left, print && h.right == null ? true : false);
        printRightEdge(h.right, print);
        if (print || (h.left == null && h.right == null)) {
            System.out.println(h.value + " ");
        }
    }

    /**
     * 打印左叶节点和左边界延伸下去的路径
     * 对于打印左边界来说，左节点必打印，右节点在没有左节点的情况下打印或者右节点为叶节点。
     * @param h
     * @param print 树左边界延伸下去的路径为边界节点
     */
    private void printLeftEdge(TreeNode h, boolean print) {
        if (h == null) {
            return;
        }
        if (print || (h.left == null && h.right == null)) {
            System.out.println(h.value + " ");
        }
        printLeftEdge(h.left, print);
        printLeftEdge(h.right, print && h.left == null ? true : false);
    }
}
