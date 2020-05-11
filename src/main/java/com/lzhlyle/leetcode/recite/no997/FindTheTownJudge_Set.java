package com.lzhlyle.leetcode.recite.no997;

import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge_Set {
    public int findJudge(int N, int[][] trust) {
        int[] toArr = new int[N + 1];
        Set<Integer> fromSet = new HashSet<>();
        for (int[] t : trust) {
            fromSet.add(t[0]);
            toArr[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (toArr[i] == N - 1 && !fromSet.contains(i)) return i;
        }
        return -1;
    }
}
