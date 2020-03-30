package com.lzhlyle.leetcode.week.no945;

public class MinimumIncrementToMakeArrayUnique_Freq {
    // O(n)
    public int minIncrementForUnique(int[] arr) {
        int[] freq = new int[40001];
        for (int num : arr) freq[num]++;
        int cnt = 0;
        for (int num = 0; num < 40000; num++) {
            if (freq[num] > 1) {
                int more = freq[num] - 1;
                cnt += more;
                freq[num + 1] += more;
            }
        }
        int n = freq[40000] - 1;
        return cnt + n * (n + 1) / 2;
    }
}
