package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer58II {

    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2+s1;
    }
}
