package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/29
 */
public class LeetCode1456 {

    /**
     * 这种固定长度k的，一般开启来就要用滑动窗口
     * 维护一个窗口，记录每个窗口的元音字母数，遍历所有窗口，取最大
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int maxVowelMount=0;
        int vowelMount=0;
        for (int i = 0; i < k; i++) {
            if (checkVowel(s.charAt(i))) {
                vowelMount++;
            }
        }
        maxVowelMount = vowelMount;
        for (int i = k; i < s.length(); i++) {
            if (checkVowel(s.charAt(i - k))) {
                vowelMount--;
            }
            if (checkVowel(s.charAt(i))) {
                vowelMount++;
            }
            maxVowelMount = Math.max(maxVowelMount, vowelMount);
        }
        return maxVowelMount;
    }

    private boolean checkVowel(char charAt) {
        return charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u';
    }

    public static void main(String[] args) {
        LeetCode1456 leetCode1456 = new LeetCode1456();
        int i = leetCode1456.maxVowels("abciiidef", 3);
        System.out.println(i);
    }
}
