package com.lzhlyle.leetcode.self.no1114;

public class Foo_Sync_NonBlocking_CAS {
    // 同步-非阻塞-CAS
    private volatile int expected;

    public Foo_Sync_NonBlocking_CAS() {
        expected = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        expected = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (expected != 2) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        expected = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (expected != 3) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
