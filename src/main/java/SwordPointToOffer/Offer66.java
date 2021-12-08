package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/26
 */
public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return new int[0];
        }
        int len = a.length;
        int[] b = new int[len];
        int tmp = 1;
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = a[i - 1] * b[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
