package com.lzhlyle.leetcode.self.no621;

import java.util.Arrays;

public class TaskScheduler_2 {
    public int leastInterval(char[] tasks, int n) {
        // base condition
        if (n == 0) return tasks.length;
        if (tasks.length == 1) return 1;

        // 分为26组
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        // 按组内次数排列
        Arrays.sort(freq); // O(log(n))

        int nonMostFrequencyCnt = 25;
        while (nonMostFrequencyCnt >= 0 && freq[nonMostFrequencyCnt] == freq[25]) nonMostFrequencyCnt--;

        return Math.max(tasks.length,
                (freq[25] - 1) * (n + 1) + (25 - nonMostFrequencyCnt));
    }
}
