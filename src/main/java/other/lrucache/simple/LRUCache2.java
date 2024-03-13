package other.lrucache.simple;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/13
 * {@code @description:}
 */
public class LRUCache2<K,V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public LRUCache2(int capacity) {
        super(capacity, .75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache2<Integer, Integer> cache = new LRUCache2<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(15, 1);
        cache.put(3, 3);
        cache.get(15);

        System.out.println(cache.toString());
    }
}
