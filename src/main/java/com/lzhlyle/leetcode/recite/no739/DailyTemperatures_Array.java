package com.lzhlyle.leetcode.recite.no739;

public class DailyTemperatures_Array {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        if (n < 2) return new int[n];

        int[] res = new int[n], arr = new int[n]; // arr: desc-stack
        for (int i = 1, ai = 1; i < n; i++) {
            while (ai > 0 && T[arr[ai - 1]] < T[i]) {
                int j = arr[ai-- - 1];
                res[j] = i - j;
            }
            arr[ai++] = i;
        }
        return res;
    }
}
