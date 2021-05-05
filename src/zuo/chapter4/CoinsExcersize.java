package zuo.chapter4;

/**
 * @author keboom
 * @date 2021/4/9
 */
public class CoinsExcersize {

    // 暴力递归法
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= aim; i++) {
                res += process1(arr, index + 1, aim - i * arr[index]);
            }
        }
        return res;
    }

    // 记忆化搜索， 用map存储计算过的过程，有两个变量，index和aim，因此二维数组。
    // 为了考虑计算过但res仍未0的过程，所以-1表示计算过，但res仍为0
    // 0表示没有计算过，int数组初始化就是为0
    // 其他数字表示res的数量
    public int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    private int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= aim; i++) {
                int mapValue = map[index + 1][aim - i * arr[index]];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }


    // 动态规划，明确两个变量，index和aim，创建二维dp数组，index为行，aim为列
    // 初始化数组，对于第一列，aim等于0，值都为1。第一行，表示index等于0，表示只能使用arr[0]这个元素，所以对于aim为arr[0]的整数倍的位置的值为1，其余为0
    // 状态转移方程，对于第二行和以后的行数，分为使用0，使用1，使用k等情况的和。
    public int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }
        int num;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num=0;
                for (int k = 0; j-arr[i]*k>=0; k++) {
                    num += dp[i-1][j-arr[i]*k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length-1][aim];
    }


    public static void main(String[] args) {
        CoinsExcersize excersize = new CoinsExcersize();
        int[] arr = {5, 10, 25, 1};
//        System.out.println(excersize.coins1(arr, 15));
        System.out.println(excersize.coins2(arr, 15));
    }
}
