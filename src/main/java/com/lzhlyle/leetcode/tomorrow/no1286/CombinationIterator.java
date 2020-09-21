package com.lzhlyle.leetcode.tomorrow.no1286;

public class CombinationIterator {
    private char[] arr;
    private int n;
    private int[] last;
    private char[] next;

    public CombinationIterator(String characters, int combinationLength) {
        arr = characters.toCharArray();
        n = combinationLength;
        last = new int[n];
        next = new char[n];
    }

    public String next() {
        if (next[0] < 'a') {
            for (int i = 0; i < n; i++)
                next[i] = arr[last[i] = i];
            return new String(next);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (last[i] + n - i < arr.length) {
                next[i] = arr[++last[i]];
                for (int j = i + 1; j < n; j++)
                    next[j] = arr[last[j] = last[j - 1] + 1];
                return new String(next);
            }
        }
        return "-1";
    }

    public boolean hasNext() {
        return last[0] < arr.length - n;
    }
}
