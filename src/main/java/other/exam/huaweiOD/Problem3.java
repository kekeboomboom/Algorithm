package other.exam.huaweiOD;

import java.util.*;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/16
 */
public class Problem3 {

    // 内存表
    static TreeMap<Integer, Integer> table = new TreeMap<>();
    /**
     * 5
     * REQUEST=10
     * REQUEST=20
     * RELEASE=0
     * REQUEST=20
     * REQUEST=10
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operateCount = Integer.valueOf(sc.nextLine());
        while (operateCount > 0) {
            operateCount--;
            String ope = sc.nextLine();
            System.out.println(ope);
            String[] split = ope.split("=");
            String operate = split[0];
            Integer num = Integer.valueOf(split[1]);
            if (operate.equals("REQUEST")) {
                request(num);
            } else {
                release(num);
            }
        }

    }

    static void request(int size) {
        if (table.size() == 0) {
            table.put(0, size - 1);
            System.out.println(0);
            return;
        }
        // 先看首地址有没有分配，如果分配了，那么顺着table一直找合适的。如果找不到返回error
        // 如果首地址没分配，那么尝试是否可以进行分配。可以就分配，不可以就顺着table一直找
        if (!table.containsKey(0)) {
            if (size <= table.firstKey()) {
                table.put(0, size-1);
                System.out.println(0);
                return;
            }
        }

        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue() + size > 99) {
                System.out.println("error");
                return;
            }
            Map.Entry<Integer, Integer> nextEntry = table.higherEntry(entry.getKey());
            if (nextEntry == null) {
                table.put(entry.getValue() + 1, entry.getValue()+size);
                System.out.println(entry.getValue()+1);
                return;
            }
            // 如果下一个节点起始和当前节点结尾，大小小于size，那么就不够分配
            if ((nextEntry.getKey() - entry.getValue() - 1) < size) {
                continue;
            } else {
                table.put(entry.getValue() + 1, entry.getValue()+size);
                System.out.println(entry.getValue()+1);
                return;
            }

        }
    }

    static void release(int addr) {
        // 看看table中是否有以addr开头的，如果没有则返回error
        // 如果有，则释放
        if (table.containsKey(addr)) {
            table.remove(addr);
        } else {
            System.out.println("error");
        }
    }
}
