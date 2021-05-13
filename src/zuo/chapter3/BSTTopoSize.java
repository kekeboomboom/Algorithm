package zuo.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keboom
 * @date 2021/5/10
 */
public class BSTTopoSize {

    // 以head为头结点寻找最大拓扑结构大小
    public int bstTopoSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        // 往左找
        max = Math.max(bstTopoSize1(head.left), max);
        // 往右找
        max = Math.max(bstTopoSize1(head.right), max);
        return max;
    }

    // 给定了h，递归得到最大拓扑结构大小
    private int maxTopo(Node h, Node n) {
        if (h != null && n != null && isBSTNode(h, n, n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    // 判断n节点是否为以h为头结点的二叉搜索树的子节点
    private boolean isBSTNode(Node h, Node n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBSTNode(h.value > value ? h.left : h.right, n, value);
    }




    //方法2---------------------暂时看不懂。。。。to do。。。。。。。
    class Record{
        public int l;
        public int r;

        public Record(int left, int right) {
            this.l = left;
            this.r = right;
        }
    }

    public int bstTopoSize2(Node head) {
        Map<Node, Record> map = new HashMap<>();
        return posOrder(head, map);
    }

    private int posOrder(Node h, Map<Node, Record> map) {
        if (h == null) {
            return 0;
        }
        int ls = posOrder(h.left, map);
        int rs = posOrder(h.right, map);
        modifyMap(h.left, h.value, map, true);
        modifyMap(h.right, h.value, map, false);
        Record lr = map.get(h.left);
        Record rr = map.get(h.right);
        int lbst = lr == null ? 0 : lr.l + lr.r + 1;
        int rbst = rr == null ? 0 : rr.l + rr.r + 1;
        map.put(h, new Record(lbst, rbst));
        return Math.max(lbst + rbst + 1, Math.max(ls, rs));
    }

    private int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
        if (n == null || (!m.containsKey(n))) {
            return 0;
        }
        Record r = m.get(n);
        if ((s && n.value > v) || ((!s) && n.value < v)) {
            m.remove(n);
            return r.l + r.r + 1;
        } else {
            int minus = modifyMap(s ? n.right : n.left, v, m, s);
            if (s) {
                r.r = r.r - minus;
            } else {
                r.l = r.l - minus;
            }
            m.put(n, r);
            return minus;
        }
    }
}
