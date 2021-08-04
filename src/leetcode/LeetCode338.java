package leetcode;

/**
 * @author keboom
 * @date 2021/8/3
 */
public class LeetCode338 {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countN(i);
        }
        return bits;
    }

    private int countN(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i-highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(5));
    }
}
