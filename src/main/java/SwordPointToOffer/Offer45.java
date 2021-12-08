package SwordPointToOffer;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/7/24
 */
public class Offer45 {


    /**
     * 给我两个数我原来的想法是，比较两个数的最高位数字，来判断将那个数字放到前面，比如3和30
     * 首先比较3和3，然后比较3和0，因此我们决定将30放到前面，组成303
     *
     * 那么我看题解的解答，直接将两个数结合，比较大小，303和330比较大小，然后就能判断谁放前面了
     * 那么此时我们就将其变成了一个排序问题，究竟时让3排前面，还是30排前面呢？
     * 那么通过 comapreTo可以判断这个数组合后大小
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, ((x, y) -> (x + y).compareTo(y + x)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int i = "5".compareTo("7");
        System.out.println();
    }
}
