package com.lzhlyle.leetcode.recite.no621;

import java.util.Arrays;

public class TaskScheduler {
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

        // 最多出现的次数
        int maxCnt = map[25] - 1; // 至少maxCnt
        int idleCnt = (maxCnt) * n; // 计算最多的空闲位
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            // 占用空闲位
            idleCnt -= Math.min(map[i], maxCnt);
        }

        return Math.max(idleCnt, 0) + tasks.length;
    }
}
