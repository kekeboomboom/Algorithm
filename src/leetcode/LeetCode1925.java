package leetcode;

import java.util.List;

/**
 * @author keboom
 * @date 2021/3/4
 */
public class LeetCode1925 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }

    public static void move(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        //当盘子都移动空了之后停止递归
        if (n <= 0) {
            return ;
        } else {
            move(n - 1, a, c, b);
            //此时将 A 底下的那块最大的圆盘移到 C
            c.add(a.remove(a.size()-1));
            move(n - 1, b, a, c);
        }
    }
}
