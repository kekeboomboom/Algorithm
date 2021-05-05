package zuo.chapter4;

/**
 * @author keboom
 * @date 2021/4/18
 *
 * 打气球最大分数
 */
public class MaxCosins {

    // process的意义为找到L到R的最大总分
    // 终止条件：L==R
    // 状态转移：1,最后打爆L或R。2、最后打爆i（L<i<R）
    public int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        // 最后打爆L或R
        int max = Math.max(
                arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
                arr[L - 1] * arr[R] * arr[R + 1] + process(arr, L, R - 1));
        // 最后打爆i
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max,
                    process(arr, L, i - 1) + process(arr, i + 1, R)
                            + arr[L - 1] * arr[i] * arr[R + 1]);
        }
        return max;
    }

    // 把原本的arr两头补上1，这样就省得判断边界条件
    public int maxCoins1(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int len = arr.length;
        int[] help = new int[len+2];
        help[0]=1;
        help[len+1]=1;
        for (int i = 0; i < len; i++) {
            help[i+1] = arr[i];
        }
        return process(help, 1, len);
    }
}
