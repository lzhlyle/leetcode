package com.lzhlyle.leetcode.self.no1195;

import java.util.function.IntConsumer;

public class FizzBuzz_Sync_Blocking_Synchronized {
    // 同步-阻塞-synchronized
    private int n;
    private volatile int i;

    public FizzBuzz_Sync_Blocking_Synchronized(int n) {
        this.n = n;
        this.i = 1;
    }

    private boolean mod(int i, int base) {
        return i % base == 0;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            if (mod(i, 3) && !mod(i, 5)) {
                printFizz.run();
                i++;
                notifyAll();
            } else wait();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            if (!mod(i, 3) && mod(i, 5)) {
                printBuzz.run();
                i++;
                notifyAll();
            } else wait();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            if (mod(i, 3) && mod(i, 5)) {
                printFizzBuzz.run();
                i++;
                notifyAll();
            } else wait();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            if (!mod(i, 3) && !mod(i, 5)) {
                printNumber.accept(i);
                i++;
                notifyAll();
            } else wait();
        }
    }
}
