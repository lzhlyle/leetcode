package com.lzhlyle.leetcode.self.no957;

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] map = new int[1 << 8]; // 所有状态机
        Arrays.fill(map, -1);
        int[] pre = new int[1 << 8]; // 上次出现的位置
        Arrays.fill(pre, -1);

        int c = 0b0;
        for (int i = 0; i < 8; i++)
            c |= cells[i] << i;

        for (int i = 1; i <= N; i++) {
            int key = c;
            if (map[key] != -1) {
                c = map[key];
                int step = i - pre[key]; // 成环的步长
                int m = (N - i) / step; // 路径压缩
                if (m > 0) i += m * step;
            } else {
                c = next(key);
                map[key] = c;
                pre[key] = i;
            }
        }

        int[] res = new int[8];
        for (int i = 0; i < 8; i++)
            res[i] = get(c, i);
        return res;
    }

    private int next(int c) {
        int res = 0b0;
        for (int i = 1; i < 7; i++)
            if (get(c, i - 1) == get(c, i + 1))
                res |= 1 << i;
        return res;
    }

    private int get(int c, int i) {
        return (c >> i) & 1;
    }
}
