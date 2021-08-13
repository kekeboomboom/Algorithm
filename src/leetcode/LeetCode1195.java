package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author keboom
 * @date 2021/8/13
 */
public class LeetCode1195 {

    private int n;
    private Semaphore spNumber;
    private Semaphore spFizz;
    private Semaphore spBuzz;
    private Semaphore spFizzbuzz;

    public LeetCode1195(int n) {
        this.n = n;
        spNumber = new Semaphore(1);
        spFizz = new Semaphore(0);
        spBuzz = new Semaphore(0);
        spFizzbuzz = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                spFizz.acquire();
                printFizz.run();
                spNumber.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                spBuzz.acquire();
                printBuzz.run();
                spNumber.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                spFizzbuzz.acquire();
                printFizzBuzz.run();
                spNumber.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            spNumber.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                spFizzbuzz.release();
            } else if (i % 3 == 0) {
                spFizz.release();
            } else if (i % 5 == 0) {
                spBuzz.release();
            } else {
                printNumber.accept(i);
                spNumber.release();
            }
        }
    }
}
