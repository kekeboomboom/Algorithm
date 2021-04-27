package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/3/15
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3 - 1;
        long rem = 1;
        long x = 3;
        while (a > 0) {
            if ((a & 1) == 1) {
                rem = rem * x % 1000000007;
            }
            x = x * x % 1000000007;
            a >>= 1;
        }
        int b = n % 3;
        if (b == 0) {
            return (int) (rem * 3 % 1000000007);
        } else if (b == 1) {
            return (int) (rem * 4 % 1000000007);
        } else {
            return (int) (rem * 6 % 1000000007);
        }
    }
}
