package com.lzhlyle.leetcode.self.no1117;

public class BuildingH2o_Sync_Blocking_Synchronized {
    private int h, o;

    public BuildingH2o_Sync_Blocking_Synchronized() {
        h = o = 0;
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (h == 2 && o < 1)
            wait();
        if (h == 2 && o == 1)
            h = o = 0;
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        h++;
        notify();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (o == 1 && h < 2)
            wait();
        if (h == 2 && o == 1)
            h = o = 0;
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        o++;
        notify();
    }
}
