package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/8/9
 */
public class LeetCode406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 90);
        list.add(1, 70);
        list.add(1, 80);
        list.add(1,20);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
