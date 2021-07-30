package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer44 {

    public int findNthDigit(int n) {
        Long start = 1l;
        int digit = 1;
        Long count = 9l;
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        Long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
