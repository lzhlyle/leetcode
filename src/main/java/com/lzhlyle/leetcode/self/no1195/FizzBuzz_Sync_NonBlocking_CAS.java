package com.lzhlyle.leetcode.self.no1195;

import java.util.function.IntConsumer;

public class FizzBuzz_Sync_NonBlocking_CAS {
    // 同步-非阻塞-CAS

    private int n;
    private int i;
    private volatile int expected;

    public FizzBuzz_Sync_NonBlocking_CAS(int n) {
        this.n = n;
        i = 1;
        expected = 0;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            while (i <= n && expected != 1) ;
            if (i > n) return;

            printFizz.run();
            i++;
            expected = 0;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            while (i <= n && expected != 2) ;
            if (i > n) return;

            printBuzz.run();
            i++;
            expected = 0;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            while (i <= n && expected != 3) ;
            if (i > n) return;

            printFizzBuzz.run();
            i++;
            expected = 0;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while (i <= n && expected != 0) ;
            if (i > n) return;

            if (i % 15 == 0) expected = 3;
            else if (i % 5 == 0) expected = 2;
            else if (i % 3 == 0) expected = 1;
            else {
                printNumber.accept(i);
                i++;
            }
        }
    }
}
