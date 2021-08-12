package leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode1114II {

    private CountDownLatch cd1;
    private CountDownLatch cd2;

    public LeetCode1114II() {
        cd1 = new CountDownLatch(1);
        cd2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        cd1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cd1.await();
        printSecond.run();
        cd2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cd2.await();
        printThird.run();
    }
}
