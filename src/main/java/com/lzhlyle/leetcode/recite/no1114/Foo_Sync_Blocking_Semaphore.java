package com.lzhlyle.leetcode.recite.no1114;

import java.util.concurrent.Semaphore;

public class Foo_Sync_Blocking_Semaphore {
    // 同步-阻塞-信号量
    private Semaphore sem2, sem3;

    public Foo_Sync_Blocking_Semaphore() {
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sem3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
