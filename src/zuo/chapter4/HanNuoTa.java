package zuo.chapter4;

/**
 * @author keboom
 * @date 2021/4/19
 * 汉诺塔问题
 */
public class HanNuoTa {
    public void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "mid", "right");
        }
    }
    // 递归真的太简洁了，但也抽象。
    public void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            // 将左边n-1移动到中间
            func(n - 1, from, to, mid);
            // 将左边最后一个移动右边
            func(1, from, mid, to);
            // 将中间的n-1移动的右边
            func(n - 1, mid, from, to);
        }
    }

    public static void main(String[] args) {
        HanNuoTa test = new HanNuoTa();
        test.hanoi(3);
    }
}
