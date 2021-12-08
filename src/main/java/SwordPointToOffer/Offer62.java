package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/26
 */
public class Offer62 {

    /**
     * 此问题为约瑟夫环问题，有数学推导可得 f(n) = (f(n-1) + m) % n
     * n为总人数，m为第几个人死去
     * n=1,m=3  f(1) = 0  0表示索引，表示最后剩下的是0位置上的数字
     * n=2,m=3  f(2) = (0 + 3) % 2 = 1
     * n=3,m=3  f(3) = (1 + 3) % 3 = 1
     * n=4
     * n=5       f(5) = (f(4) + 3) % 5 =
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int x= 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
