package com.lzhlyle.leetcode.recite.no945;

public class MinimumIncrementToMakeArrayUnique {
    // O(n)
    public int minIncrementForUnique(int[] arr) {
        int len = arr.length, cnt = 0;
        if (len == 0) return 0;
        int[] freq = new int[40001];
        for (int num : arr) freq[num]++;
        for (int i = 0; i < len - 1; i++) {
            int f = freq[i];
            if (f > 1) {
                freq[i] -= f - 1;
                freq[i + 1] += f - 1;
                cnt += f - 1;
            }
        }
        if (freq[len - 1] > 1) {
            int n = freq[len - 1] - 1;
            cnt += n * (n + 1) / 2;
        }
        return cnt;
    }
}
