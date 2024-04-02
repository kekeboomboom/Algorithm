import SwordPointToOffer.JZ;
import common.ListNode;
import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1, 1, 1, 2, 2, 3};
        main.topKFrequent(nums, 2);

    }


    /**
     * 前 k 个数字，一般前 k 个数字的这种题目都是使用堆去做。
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[][] mapArr = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mapArr[i][0] = entry.getKey();
            mapArr[i][1] = entry.getValue();
            i++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int[] arr : mapArr) {
            queue.add(arr);
        }
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = Objects.requireNonNull(queue.poll())[0];
        }
        return result;
    }
}
