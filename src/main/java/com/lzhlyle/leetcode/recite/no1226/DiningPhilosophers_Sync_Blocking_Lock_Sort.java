package com.lzhlyle.leetcode.recite.no1226;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers_Sync_Blocking_Lock_Sort {
    // 优先拿小序号叉

    private Lock[] arr;

    public DiningPhilosophers_Sync_Blocking_Lock_Sort() {
        arr = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int l = (philosopher + 1) % 5;
        int r = philosopher;

        arr[Math.min(l, r)].lock();
        arr[Math.max(l, r)].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        putLeftFork.run();
        arr[l].unlock();

        putRightFork.run();
        arr[r].unlock();
    }
}
