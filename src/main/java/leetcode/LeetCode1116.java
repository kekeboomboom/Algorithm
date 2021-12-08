package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode1116 {

    private int n;
    private Semaphore sp0,spe,spo;

    public LeetCode1116(int n) {
        this.n = n;
        sp0 = new Semaphore(1);
        spe = new Semaphore(0);
        spo = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            sp0.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {
                spo.release();
            } else {
                spe.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n ; i+=2) {
            spe.acquire();
            printNumber.accept(i);
            sp0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i+=2) {
            spo.acquire();
            printNumber.accept(i);
            sp0.release();
        }
    }
}
