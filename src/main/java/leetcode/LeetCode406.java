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
        LeetCode406 leetCode406 = new LeetCode406();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = leetCode406.reconstructQueue(people);

    }
}
