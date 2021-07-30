package zuo;

import zuo.chapter3.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author keboom
 * @date 2021/4/28
 */
public class Excesize {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

//        Excesize ex = new Excesize();
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        int[] res = new int[T];
//        for (int i = 0; i < T; i++) {
//            int n = sc.nextInt();
//            int[] xi = new int[n];
//            for (int j = 0; j < n; j++) {
//                xi[j] = sc.nextInt();
//            }
//            int[] yj = new int[n];
//            for (int j = 0; j < n; j++) {
//                yj[j] = sc.nextInt();
//            }
//            res[i] = ex.mostGetGoods(n, xi, yj);
//        }
//        for (int i = 0; i < T; i++) {
//            System.out.println(res[i]);
//        }
    }

    public class Goods {
        public int x;
        public int y;

        public Goods(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class goodsCompator implements Comparator<Goods> {
        @Override
        public int compare(Goods o1, Goods o2) {
            return o1.x - o2.x;
        }
    }

    public int mostGetGoods(int n, int[] xi, int[] yj) {
        Goods[] goods = new Goods[n];
        for (int i = 0; i < goods.length; i++) {
            Goods gs = new Goods(xi[i], yj[i]);
            goods[i] = gs;
        }
        Arrays.sort(goods, new goodsCompator());
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = goods[i].y;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (y[j] < y[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxlen = Math.max(maxlen, dp[i]);
                }
            }
        }
        return maxlen;
    }

}
