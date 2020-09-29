package com.lzhlyle.leetcode.self.no1114;

import java.util.concurrent.CountDownLatch;

public class Foo_Sync_Blocking_Mutex_CountDownLatch {
    // 同步-阻塞-互斥量
    private CountDownLatch c2, c3;

    public Foo_Sync_Blocking_Mutex_CountDownLatch() {
        c2 = new CountDownLatch(1);
        c3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        c3.countDown();
    }
}
