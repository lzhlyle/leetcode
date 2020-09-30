package com.lzhlyle.leetcode.self.no1115;

public class PrintFoobarAlternately_Sync_NonBlocking_CAS {
    private int n;
    private volatile int state;

    public PrintFoobarAlternately_Sync_NonBlocking_CAS(int n) {
        this.n = n;
        this.state = 1;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 1)
                Thread.yield();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            state = 2;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 2)
                Thread.yield();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            state = 1;
        }
    }
}
