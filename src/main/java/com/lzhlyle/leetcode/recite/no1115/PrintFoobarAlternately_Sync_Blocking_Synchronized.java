package com.lzhlyle.leetcode.recite.no1115;

public class PrintFoobarAlternately_Sync_Blocking_Synchronized {
    private int n;
    private volatile int state;

    public PrintFoobarAlternately_Sync_Blocking_Synchronized(int n) {
        this.n = n;
        this.state = 1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 1)
                wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            state = 2;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 2)
                wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            state = 1;
            notify();
        }
    }
}
