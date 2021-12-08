package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer58 {

    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i] + " ");
        }
        return sb.toString().trim();

    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        String[] strings = s.trim().split("\\s+");
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
