package com.lzhlyle.leetcode.self.no1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd_Sync_Blocking_Semaphore {
    private int n;
    private Semaphore sem0, sem1, sem2;

    public ZeroEvenOdd_Sync_Blocking_Semaphore(int n) {
        this.n = n;
        sem0 = new Semaphore(1);
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            sem0.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) sem1.release();
            if ((i & 1) == 0) sem2.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sem1.acquire();
            printNumber.accept(i);
            sem0.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sem2.acquire();
            printNumber.accept(i);
            sem0.release();
        }
    }
}
