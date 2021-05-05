package zuo.chapter3;

/**
 * @author keboom
 * @date 2021/4/30
 */
public class PrintEdgeNode {

    public void printEdge1(Node head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
    }

    private void setEdgeMap(Node head, int l, Node[][] edgeMap) {
        if (head == null) {
            return;
        }

    }

    private int getHeight(Node head, int height) {
        if (head == null) {
            return height;
        }
        return Math.max(getHeight(head.left, height + 1), getHeight(head.right, height + 1));
    }
}
