package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/3
 */
public class LeetCode204 {

    /**
     * 埃氏筛，从2开始，2是质数，那么以2为倍数的数不是质数设置为false
     * 然后是3，3是质数为true，以3为倍数的数不是质数设置为false
     * 然后是4，4是2的倍数，已经被设置成false了
     * 然后是5，以5为倍数的数设置为false
     * 然后是6，已经被设置为false
     * 。。。。。。。。。
     * 值得注意的是我们只需要遍历到根号n即可。
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 我们将不是质数的设置为false
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        int count = 0;
        // 最后我们遍历isPrime为true的就是质数
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
