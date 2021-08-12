package leetcode;

/**
 * @author keboom
 * @date 2021/8/10
 */
public class LeetCode1115 {

    private int n;
    Object lock = new Object();
    private int flag = 0;

    public LeetCode1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                if (flag != 0) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                if (flag != 1) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                lock.notify();
            }
        }
    }
}
