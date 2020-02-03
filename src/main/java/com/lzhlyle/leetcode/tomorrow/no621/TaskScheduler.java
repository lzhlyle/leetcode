package com.lzhlyle.leetcode.tomorrow.no621;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length < 2 || n < 1) return tasks.length;

        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;

        Arrays.sort(freq);

        int maxGroupCnt = freq[25] - 1;
        int currIdleCnt = maxGroupCnt * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            currIdleCnt -= Math.min(freq[i], maxGroupCnt);
        }
        return Math.max(0, currIdleCnt) + tasks.length;
    }
}
