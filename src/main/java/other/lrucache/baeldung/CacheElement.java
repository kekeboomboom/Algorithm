package other.lrucache.baeldung;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/3/13
 * {@code @description:}
 */
public class CacheElement<K,V> {
    private K key;
    private V value;

    public CacheElement(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
