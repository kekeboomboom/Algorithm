package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/26
 */
public class Offer67 {

    public int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if (s.length == 0) {
            return 0;
        }
        int res = 0;
        int jie = Integer.MAX_VALUE / 10;
        int i = 1;
        int sign = 1;
        if (s[0] == '-') {
            sign = -1;
        } else if (s[0] != '+') {
            i = 0;
        }
        for (int j = i; j < s.length; j++) {
            if (s[j] < '0' || s[j] > '9') {
                break;
            }
            if (res > jie || res == jie && s[j] > '7') {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + (s[j] - '0');
        }
        return sign * res;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}

