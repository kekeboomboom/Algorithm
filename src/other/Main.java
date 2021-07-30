package other;

import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/7/21
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] result = new String[T];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
                if (x[j] == 0) {
                    result[i] = "Yes";
                    break;
                }
            }
            boolean res = sum(x, y);
            if (res) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }

    public static boolean sum(int[] x, int[] y){
        int[] res = {x[0],y[0]};
        for (int i = 1; i < x.length; i++) {
            int[] merge = merge(res[0], res[1], x[i], y[i]);
            res[0] = merge[0];
            res[1] = merge[1];
        }
        if (res[0] == res[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] merge(int x1, int y1,int x2,int y2) {
        int mu = 1;
        if (y2 % y1 == 0) {
            mu = y2;
            x1 = y2/y1 * x1;
        } else {
            mu = y1 * y2;
            x1 = y2 * x1;
            x2 = y1 * x2;
        }
        int x = x1 + x2;
        return new int[]{x, mu};
    }
}
