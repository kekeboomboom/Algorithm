package leetcode;

/**
 * 多线程类题目，按序打印，就是先执行first，在执行second，在执行third
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode1114 {

    private int flag = 0;
    Object lock = new Object();

    public LeetCode1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != 0) {
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printThird.run();
            flag = 3;
            lock.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}
