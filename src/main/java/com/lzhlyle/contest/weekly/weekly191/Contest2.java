package com.lzhlyle.contest.weekly.weekly191;

import java.util.Arrays;

public class Contest2 {
    private static final int MOD = 1000000007;

    public int maxArea(int h, int w, int[] harr, int[] varr) {
        int hlen = harr.length, vlen = varr.length;

        Arrays.sort(harr);
        long maxH = harr[0];
        for (int i = 1; i < hlen; i++) {
            maxH = Math.max(maxH, harr[i] - harr[i - 1]);
        }
        maxH = Math.max(maxH, h - harr[hlen - 1]);

        Arrays.sort(varr);
        long maxV = varr[0];
        for (int i = 1; i < vlen; i++) {
            maxV = Math.max(maxV, varr[i] - varr[i - 1]);
        }
        maxV = Math.max(maxV, w - varr[vlen - 1]);

        return (int) ((maxH * maxV) % MOD);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
