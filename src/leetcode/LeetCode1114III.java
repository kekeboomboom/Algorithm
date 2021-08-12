package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode1114III {

    private Semaphore sp1,sp2;

    public LeetCode1114III() {
        sp1 = new Semaphore(0);
        sp2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        sp1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sp1.acquire();
        printSecond.run();
        sp2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sp2.acquire();
        printThird.run();
    }
}
