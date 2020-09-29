package com.lzhlyle.leetcode.self.no1226;

public class DiningPhilosophers_Sync_Blocking_Synchronized {
    // 全场只有一个人能吃

    public DiningPhilosophers_Sync_Blocking_Synchronized() {

    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                                        Runnable pickLeftFork,
                                        Runnable pickRightFork,
                                        Runnable eat,
                                        Runnable putLeftFork,
                                        Runnable putRightFork) throws InterruptedException {
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
    }
}
