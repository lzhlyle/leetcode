package com.lzhlyle.leetcode.self.no945;

public class MinimumIncrementToMakeArrayUnique {
    // O(n)
    public int minIncrementForUnique(int[] arr) {
        int len = arr.length, cnt = 0;
        if (len == 0) return 0;
        int[] freq = new int[40001];
        for (int num : arr) freq[num]++;
        for (int num = 0; num < len - 1; num++) {
            int more = freq[num] - 1;
            if (more > 0) {
                freq[num] -= more;
                freq[num + 1] += more;
                cnt += more;
            }
        }
        if (freq[len - 1] > 1) {
            int n = freq[len - 1] - 1;
            cnt += n * (n + 1) / 2;
        }
        return cnt;
    }
}
