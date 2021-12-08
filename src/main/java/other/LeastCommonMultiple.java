package other;

/**
 * @author keboom
 * @date 2021/7/22
 */
public class LeastCommonMultiple {

    /*
    要求两个数的最小公倍数，那就要求两个数的最大公约数，
    两数乘积 = 最大公约数和最小公倍数的积
    比如4 6 的最小公约数为2，最大公倍数为12，所以 4 * 6 = 2 * 12
     */

    /**
     * 辗转相除法，得到最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int fa(int a, int b) {
        int small = a > b ? b : a;
        int big = a > b ? a : b;
        int tmp = 0;
        while (small != 0) {
            tmp = small;
            small = big % small;
            big = tmp;
        }
        return big;
    }

    public static void main(String[] args) {
        int a = 27;
        int b = 15;
        // 那么我们可以求最小公倍数了！
        int minBei = a * b / fa(a, b);
        System.out.println(minBei);
    }

}
