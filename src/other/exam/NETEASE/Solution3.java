package other.exam.NETEASE;

import java.util.*;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution3 {

    //80  围成一圈小孩发纸，岁数大的要邻近的多发，求最少要多少只
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        int[][] map = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
            map[i][0] = nums[i];
            map[i][1] = i;
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        if (nums.length == 1) {
            System.out.println(1);
            return;
        }
//        System.out.println(map.toString());
        int[] papers = new int[nums.length];
//        System.out.println(Arrays.deepToString(map));
        for (int[] ints : map) {
            int index = ints[1];
            int max = 0;
            boolean isequals = false;
            if (index == 0) {
                max = Math.max(papers[papers.length - 1], papers[1]);
                if (nums[index] == nums[papers.length - 1] || nums[index] == nums[1]) {
                    isequals = true;
                }
            } else if (index == papers.length - 1) {
                max = Math.max(papers[index - 1], papers[0]);
                if (nums[index] == nums[index - 1] || nums[index] == nums[0]) {
                    isequals = true;
                }
            } else {
                max = Math.max(papers[index - 1], papers[index + 1]);
                if (nums[index] == nums[index - 1] || nums[index] == nums[index + 1]) {
                    isequals = true;
                }
            }
            papers[index] = isequals ? max : max + 1;
            if (papers[index] == 0) {
                papers[index] = 1;
            }
        }
        int sum = 0;
        for (int i : papers) {
            sum += i;
        }
        System.out.println(sum);

    }
}
