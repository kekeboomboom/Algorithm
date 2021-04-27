package zuo.Chapter4;

/**
 * @author keboom
 * @date 2021/3/29
 */
public class Fibonaci {

    // 暴力递归
    public int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n-1) + f1(n-2);
    }

    // 动态规划
    public int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    // 动态规划优化---滚动数组
    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int tmp = 0;
        int pre = 1;
        int res = 1;
        for (int i = 2; i < n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    // 由于是严格的递推公式，所以一定有状态矩阵
    // (F(n), F(n-1)) = (F(n-1), F(n-2)) * [[a, b], [c, d]]
    // 带入F(1,2,3,4)可以求得a,b,c,d
    // 最终将问题转换为求矩阵的幂，而求幂可以用快速幂，所以时间复杂度降为logn

    // 求矩阵的幂
    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        // 快速幂
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    // 矩阵乘法
    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public int f4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0] + res[1][0];
    }

    public static void main(String[] args) {
        Fibonaci fibonaci = new Fibonaci();
//        System.out.println(fibonaci.f1(5));
//        System.out.println(fibonaci.f2(5));
//        System.out.println(fibonaci.f3(5));
        System.out.println(fibonaci.f4(5));

//        System.out.println(fibonaci.numPower(2,10));
    }

    // 题外话，求一个数字的幂，用快速幂
    public int numPower(int n, int p) {
        int tmp =n;
        int res = 1;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = tmp*res;
            }
            tmp*=tmp;
        }
        return res;
    }

    // 上台阶问题，与斐波那契一模一样，递归条件也是一样的，仅仅是初始条件不一样而已

    // 生牛问题，递归条件为F(N) = F(N-1) + F(N-3)
    // 初始条件为 F(1) = 1, F(2) = 2, F(3) = 3, F(4) = 4, F(5) = 6;
    // 解释：想求第N年的牛，那就是N-1年的牛 加上 第N年新出生的牛，而第N年新出生的牛等于第N-3年的牛

    // 牛的代码，滚动数组
    public int c2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        // 为什么这里相较于斐波那契多了一个变量呢？
        // 原因就是F(N-3)向前移动一位时，必须用pre来记录，
        // 而斐波那契的F(N-2)向前移动一位时，只需要把原先的res值给他就行了。
        // 递归公式为F(N-1)+F(N-2) 则需要两个变量
        // 递归公式为F(N-1)+F(N-3) 则需要三个变量
        // 递归公式为F(N-1)+F(N-4) 则需要四个变量
        // 因为每次向前推进一个时，都必须要知道前一个变量的值
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = pre;
            tmp2 = res;
            res = res + prepre;
            pre = tmp2;
            prepre = tmp1;
        }
        return res;
    }

    // 关于递推公式，递推数列的阶数定义。
    //一般地，递归数列的前k项a1，a2，…，ak为已知数，
    //从第k＋1项起，由某一递推公式an+k＝f（an，an+1，…，an+k-1） ( n＝1，2，…）所确定。
    //k称为递归数列的阶数。

    // 对于牛问题的递推公式F(N)=F(N-1)+F(N-3)，是一个三阶递推公式，所以状态矩阵为3*3的矩阵
    // (C n,C n-1,C n-2)=(C n-1,C n-2,C n-3)*[[a,b,c],[d,e,f],[g,h,i]]
    // 带入求得矩阵
    public int c3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n-3);
        return 3*res[0][0] + 2*res[1][0] + res[2][0];
    }


}
