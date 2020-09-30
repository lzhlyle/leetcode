package com.lzhlyle.leetcode.recite.no1115;

import java.util.concurrent.Semaphore;

public class PrintFoobarAlternately_Sync_Blocking_Semaphore {
    private int n;
    private Semaphore semFoo, semBar;

    public PrintFoobarAlternately_Sync_Blocking_Semaphore(int n) {
        this.n = n;
        this.semFoo = new Semaphore(1);
        this.semBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semFoo.release();
        }
    }
}
