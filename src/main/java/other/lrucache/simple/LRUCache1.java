package other.lrucache.simple;

import other.lrucache.baeldung.LinkedListNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/13
 * {@code @description:}
 */
public class LRUCache1 {

    private HashMap<Integer, String> map = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<>();
    private final int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, String value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove((Object) key);
            list.addFirst(key);
        }
        if (capacity >= list.size()) {
            Integer removeLast = list.removeLast();
            map.remove(removeLast);
        }
        map.put(key, value);
        list.addFirst(key);
    }

    public String get(int key) {
        String value = map.getOrDefault(key, null);
        if (value != null) {
            list.remove((Object) key);
            list.addFirst(key);
        }
        return value;
    }
}
