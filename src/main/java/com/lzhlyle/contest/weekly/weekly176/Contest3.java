package com.lzhlyle.contest.weekly.weekly176;

public class Contest3 {
    public int maxEvents(int[][] events) {
        int eventCnt = events.length;
        int[] single = new int[eventCnt];
        for (int i = 0; i < eventCnt; i++) {
            if (events[i][0] == events[i][1]) single[i]++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
