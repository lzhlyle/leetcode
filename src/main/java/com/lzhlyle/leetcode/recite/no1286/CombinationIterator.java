package com.lzhlyle.leetcode.recite.no1286;

public class CombinationIterator {
    private char[] arr;
    private int k;
    private int[] last;
    private char[] next;

    public CombinationIterator(String characters, int combinationLength) {
        arr = characters.toCharArray();
        k = combinationLength;
        last = new int[k];
        next = new char[k];
    }

    public String next() {
        if (next[0] < 'a') {
            for (int i = 0; i < k; i++)
                next[i] = arr[last[i] = i];
            return new String(next);
        }

        for (int i = k - 1, delta = 1; i >= 0; i--, delta++) {
            if (last[i] + delta < arr.length) {
                next[i] = arr[last[i] = last[i] + 1];
                for (int j = i + 1; j < k; j++)
                    next[j] = arr[last[j] = last[j - 1] + 1];
                return new String(next);
            }
        }
        return "-1";
    }

    public boolean hasNext() {
        return last[0] < arr.length - k;
    }
}
