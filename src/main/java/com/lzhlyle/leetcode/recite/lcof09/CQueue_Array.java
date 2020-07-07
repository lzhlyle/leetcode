package com.lzhlyle.leetcode.recite.lcof09;

public class CQueue_Array {
    private int[] in, out;
    private int i, j;

    public CQueue_Array() {
        in = new int[10000];
        out = new int[10000];
        i = 0;
        j = 0;
    }

    public void appendTail(int value) {
        in[i++] = value;
    }

    public int deleteHead() {
        if (j > 0) return out[j-- - 1];
        if (i == 0) return -1;
        while (i > 0) out[j++] = in[i-- - 1];
        return out[j-- - 1];
    }
}
