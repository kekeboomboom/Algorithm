package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author keboom
 * @date 2021/8/19
 */
public class LRUCache2<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LRUCache2(int cacheSize) {
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache2<Integer, String> cache2 = new LRUCache2<>(2);
        cache2.put(1, "one");
        cache2.put(2, "two");
        System.out.println(cache2.toString());
        cache2.put(3, "three");
        System.out.println(cache2.toString());
        cache2.get(2);
        System.out.println(cache2.toString());
    }
}
