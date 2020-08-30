package com.lzhlyle.contest.weekly.weekly204;

import java.util.Arrays;

public class Contest1 {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) return false;
        for (int i = 0; i < arr.length - m; i++) {
            int[] sub = Arrays.copyOfRange(arr, i, i + m);
            int cnt = 1;
            while (cnt < k) {
                int from = i + m * cnt;
                if (from + m <= arr.length) {
                    int[] cmp = Arrays.copyOfRange(arr, from, from + m);
                    if (valid(sub, cmp)) cnt++;
                    else break;
                } else break;
            }
            if (cnt == k) return true;
        }
        return false;
    }

    private boolean valid(int[] a, int[] b) {
        for (int i = 0, j = 0; i < a.length; i++, j++)
            if (a[i] != b[j]) return false;
        return true;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
