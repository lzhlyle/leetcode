package com.lzhlyle.leetcode.self.no1226;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers_Sync_Blocking_Lock_Semaphore {
    // 最多 4 人同时拿叉

    private Lock[] arr;
    private Semaphore sem;

    public DiningPhilosophers_Sync_Blocking_Lock_Semaphore() {
        arr = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new ReentrantLock();
        }
        sem = new Semaphore(4);
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

        sem.acquire();
        arr[l].lock();
        arr[r].lock();
        sem.release();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        putLeftFork.run();
        arr[l].unlock();

        putRightFork.run();
        arr[r].unlock();
    }
}
