package com.lzhlyle.leetcode.recite.no945;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique_LC_Path {
    // O(n)
    int[] pos = new int[80000];

    public int minIncrementForUnique(int[] A) {
        Arrays.fill(pos, -1);
        int move = 0;
        for (int a : A) move += findPos(a) - a;
        return move;
    }

    private int findPos(int a) {
        int curr = pos[a];
        if (curr == -1) return pos[a] = a;

        curr = findPos(curr + 1);
        return pos[a] = curr;
    }
}
