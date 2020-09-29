package com.lzhlyle.leetcode.recite.no1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd_Sync_NonBlocking_CAS {
    private int n;
    private volatile int state;
    private volatile boolean odd;

    public ZeroEvenOdd_Sync_NonBlocking_CAS(int n) {
        this.n = n;
        state = 0;
        odd = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (state != 0) Thread.yield();
            printNumber.accept(0);
            state = odd ? 1 : 2;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) Thread.yield();
            printNumber.accept(i);
            odd = true;
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) Thread.yield();
            printNumber.accept(i);
            odd = false;
            state = 0;
        }
    }
}
