package com.lzhlyle.leetcode.tomorrow.lcof09;

public class CQueue_Array {
    private static int CAPATICY = 10000;

    private int[] in, out;
    private int i, j;

    public CQueue_Array() {
        in = new int[CAPATICY];
        out = new int[CAPATICY];
        i = 0;
        j = 0;
    }

    public void appendTail(int value) {
        in[i++] = value;
    }

    public int deleteHead() {
        if (j > 0) return out[--j];
        if (i == 0) return -1;

        while (i > 0)  out[j++] = in[--i];
        if (j > 0) return out[--j];
        return -1;
    }
}
