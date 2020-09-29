package com.lzhlyle.leetcode.recite.no1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz_Sync_Blocking_Semaphore {
    private int n;
    private volatile int i;
    private Semaphore sem, sem3, sem5, sem15;

    public FizzBuzz_Sync_Blocking_Semaphore(int n) {
        this.n = n;
        i = 1;
        sem = new Semaphore(1);
        sem3 = new Semaphore(0);
        sem5 = new Semaphore(0);
        sem15 = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            sem3.acquire();
            if (i <= n && mod3() && !mod5()) {
                printFizz.run();
                i++;
                release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            sem5.acquire();
            if (i <= n && !mod3() && mod5()) {
                printBuzz.run();
                i++;
                release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            sem15.acquire();
            if (i <= n && mod3() && mod5()) {
                printFizzBuzz.run();
                i++;
                release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            sem.acquire();
            if (i <= n && !mod3() && !mod5()) {
                printNumber.accept(i);
                i++;
                release();
            }
        }
    }

    private void release() {
        if (i > n) {
            sem.release();
            sem3.release();
            sem5.release();
            sem15.release();
        }
        if (mod3() && mod5()) sem15.release();
        else if (mod3()) sem3.release();
        else if (mod5()) sem5.release();
        else sem.release();
    }

    private boolean mod3() {
        return i % 3 == 0;
    }

    private boolean mod5() {
        return i % 5 == 0;
    }
}
