package com.lzhlyle.leetcode.self.no1114;

class Foo_Sync_Blocking_CriticalSection_Synchronized {
    // 同步-阻塞-临界区
    private int expected;

    public Foo_Sync_Blocking_CriticalSection_Synchronized() {
        expected = 1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        expected++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (expected != 2)
            wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        expected++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (expected != 3)
            wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
