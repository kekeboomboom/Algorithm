package zuo.Chapter4;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keboom
 * @date 2021/3/18
 */
public class MinCoins {

    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int j = 0; j * arr[i] <= rest; j++) {
            int next = process(arr, i + 1, rest - j * arr[i]);
            if (next != -1) {
                res =res==-1? j + next:Math.min(res,next+j);
            }
        }
        return res;
    }

    // 动态规划的方法——————————————————————————————————


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3};
        int num = new MinCoins().minCoins1(arr, 20);
        System.out.println(num);

    }
}
