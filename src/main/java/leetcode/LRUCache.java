package leetcode;

import javax.swing.*;
import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/8/5
 */
public class LRUCache {

    class Node {
        public int key,val;
        public Node next,pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        private Node head,tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.pre = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.pre.next = null;
                tail = node.pre;
            } else if (head == node) {
                node.next.pre = null;
                head = node.next;
            } else {
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
