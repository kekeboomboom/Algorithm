package other.exam.huaweiOD;

import java.util.TreeMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/16
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        System.out.println(map.higherEntry(1));
    }
}
