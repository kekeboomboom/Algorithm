package other;

/**
 * 求根号2的值
 *
 * @author keboom
 * @date 2021/7/18 15:03
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(2));
        // 牛顿迭代法 https://blog.csdn.net/j3T9Z7H/article/details/85086277
        System.out.println(mySqrt(2));
    }

    public static double mySqrt(double n) {
        //当n>=1时，从n开始迭代
        //当n<1时，从1开始迭代
        double res = n >= 1 ? n : 1;
        while (res * res - n > 1e-8) {
            res = 0.5 * (res + n / res);
        }
        return res;
    }
}
