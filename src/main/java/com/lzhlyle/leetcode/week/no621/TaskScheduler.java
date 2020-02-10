package com.lzhlyle.leetcode.week.no621;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length < 2 || n < 1) return tasks.length;

        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        Arrays.sort(freq);

        int maxGroupCnt = freq[25] - 1;
        int currIdleCnt = maxGroupCnt * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            currIdleCnt -= Math.min(maxGroupCnt, freq[i]);
        }
        return tasks.length + Math.max(0, currIdleCnt);
    }
}
