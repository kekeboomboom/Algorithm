package zuo.chapter3;

/**
 * @author keboom
 * @date 2021/4/30
 */
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }

    /**
     * 这是一个普通的二叉树
     *          10
     *     12        15
     *  4     7    5    18
     * @return
     */
    public static Node getTestTree() {
        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node15 = new Node(15);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        Node node12 = new Node(12);
        Node node18 = new Node(18);

        node10.left = node12;
        node10.right = node15;
        node12.left = node4;
        node12.right = node7;
        node15.left = node5;
        node15.right = node18;

        return node10;
    }

    /**
     * 这是一个二叉搜索树
     *          10
     *     5          15
     *  4     7    12    18
     * @return
     */
    public static Node getBSTTree() {
        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node15 = new Node(15);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        Node node12 = new Node(12);
        Node node18 = new Node(18);

        node10.left = node5;
        node10.right = node15;
        node5.left = node4;
        node5.right = node7;
        node15.left = node12;
        node15.right = node18;

        return node10;
    }
}
