package com.lzhlyle.leetcode.self.no1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd_Sync_Blocking_Synchronized {
    private int n;
    private volatile int i, expected;

    public ZeroEvenOdd_Sync_Blocking_Synchronized(int n) {
        this.n = n;
        i = 1;
        expected = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            while (expected != 0)
                wait();
            if (i <= n)
                printNumber.accept(0);
            expected = 1;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            while (expected != 1 || (i & 1) == 1)
                wait();
            if (i <= n)
                printNumber.accept(i++);
            expected = 0;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            while (expected != 1 || (i & 1) == 0)
                wait();
            if (i <= n)
                printNumber.accept(i++);
            expected = 0;
            notifyAll();
        }
    }
}
