package com.lzhlyle.leetcode.recite.no621;

import java.util.Arrays;

public class TaskScheduler_2 {
    public int leastInterval(char[] tasks, int n) {
        // base condition
        if (n == 0) return tasks.length;
        if (tasks.length == 1) return 1;

        // 分为26组
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        // 按组内次数排列
        Arrays.sort(map); // O(log(n))

        int notMostFrequencyCnt = 25; // 有几个非最高频的
        while (notMostFrequencyCnt >= 0 && map[notMostFrequencyCnt] == map[25]) {
            notMostFrequencyCnt--;
        }

        return Math.max(tasks.length, // 间隔要求小，完全够放，不会有待命位
                (map[25] - 1) * (n + 1) + // 间隔要求打，最后一组之前，必须有的长度 A ? ? ?     A ? ? ?     A ? ? ?
                        (25 - notMostFrequencyCnt)); // 最后一组最多26个(non为-1时)
    }
}
