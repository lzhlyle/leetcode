package com.lzhlyle.leetcode.tomorrow.no957;

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] state = new int[1 << 8]; // 所有状态机
        Arrays.fill(state, -1);
        int[] index = new int[1 << 8]; // 出现的位置
        Arrays.fill(index, -1);

        int c = 0b0;
        for (int i = 0; i < 8; i++)
            c |= cells[i] << i;

        for (int d = 1; d <= N; d++) {
            if (state[c] == -1) {
                int next = next(c);
                state[c] = next;
                index[c] = d;
                c = next;
            } else {
                int next = state[c];
                int round = d - index[c];
                int m = (N - d) / round; // m 轮
                if (m > 0) d += m * round;
                c = next;
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
