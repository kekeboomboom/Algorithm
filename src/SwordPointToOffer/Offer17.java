package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/3/15
 */
public class Offer17 {
    public static int printNumbers(int n) {
        int maxNum = 0;
        for(int i=0;i<n;i++){
            maxNum = (int) (maxNum+Math.pow(10,i)*9);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(printNumbers(5));
    }
}
