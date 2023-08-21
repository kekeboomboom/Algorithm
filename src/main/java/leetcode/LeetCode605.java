package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/17
 */
public class LeetCode605 {

    /**
     * 遍历数组，如果遍历到0，判断前一个和后一个都不是1，那么则可以n--
     * 如果在遍历完数组之前，n到了0，那么就是true
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) {
                if (n == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (n <= 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] ==0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowers = {1, 0, 1, 0, 1, 0, 1};

        LeetCode605 leetCode605 = new LeetCode605();
        boolean b = leetCode605.canPlaceFlowers(flowers, 1);

        System.out.println(b);
    }
}
