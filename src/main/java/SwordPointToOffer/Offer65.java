package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/26
 */
public class Offer65 {

    public static int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(3,5));
    }
}
