package zuo;

import zuo.chapter3.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/4/28
 */
public class Excesize {

    public int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right =0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public class Envelop {
        public int len;
        public int wid;

        public Envelop(int len, int wid) {
            this.len = len;
            this.wid = wid;
        }
    }

    public class EnvelopCompetor implements Comparator<Envelop> {
        @Override
        public int compare(Envelop o1, Envelop o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }

    public int mostEnvelop(int[][] matrix) {
        Envelop[] envelops = new Envelop[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            envelops[i] = new Envelop(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(envelops, new EnvelopCompetor());
        int[] ends = new int[matrix.length];
        ends[0] = envelops[0].wid;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < matrix.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (envelops[i].wid > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                right = Math.max(right, l);
                ends[l] = envelops[i].wid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Excesize exc = new Excesize();

    }
}
