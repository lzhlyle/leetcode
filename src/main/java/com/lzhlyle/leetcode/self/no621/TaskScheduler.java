package com.lzhlyle.leetcode.self.no621;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // base condition
        if (n < 1) return tasks.length;
        if (tasks.length < 2) return 1;

        // frequency map for each char
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        // sort asc, O(log(n))
        Arrays.sort(map);

        int maxGroupCnt = map[25] - 1;
        int maxIdleCnt = maxGroupCnt * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            // arrange into idle
            maxIdleCnt -= Math.min(map[i], maxGroupCnt);
        }
        return Math.max(maxIdleCnt, 0) + tasks.length;
    }
}
