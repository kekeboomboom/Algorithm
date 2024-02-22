package other.exam.huaweiOD;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/16
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (in.hasNextInt()) {
            int i = in.nextInt();
            Integer count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }
        LinkedList<Integer> mul=new LinkedList<>();
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mul = new LinkedList<>();
                mul.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                mul.add(entry.getKey());
            }
        }
        if (mul.size() == 1) {
            System.out.println(mul.get(0));
            return;
        }

        // 找中位数
        int[] array = mul.stream().mapToInt(Integer::intValue).toArray();
        if (array.length % 2 == 0) {
            System.out.println((array[array.length / 2] + array[array.length / 2 + 1]) / 2);
        } else {
            System.out.println(array[array.length / 2]);
        }
    }
}
