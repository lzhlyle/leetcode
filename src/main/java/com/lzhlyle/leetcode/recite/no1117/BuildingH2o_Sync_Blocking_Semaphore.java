package com.lzhlyle.leetcode.recite.no1117;

import java.util.concurrent.Semaphore;

public class BuildingH2o_Sync_Blocking_Semaphore {
    private Semaphore semH, semO;

    public BuildingH2o_Sync_Blocking_Semaphore() {
        semH = new Semaphore(2);
        semO = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semH.release(2);
    }
}
