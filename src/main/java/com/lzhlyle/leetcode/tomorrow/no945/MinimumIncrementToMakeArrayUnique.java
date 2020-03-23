package com.lzhlyle.leetcode.tomorrow.no945;

public class MinimumIncrementToMakeArrayUnique {
    // O(n)
    public int minIncrementForUnique(int[] arr) {
        int[] freq = new int[40001];
        // 统计频率
        for (int num : arr) ++freq[num];
        int cnt = 0;
        // 按频率累计，并后移
        for (int num = 0; num < 40000; num++) {
            int more = freq[num] - 1;
            if (more > 0) {
                freq[num + 1] += more;
                cnt += more;
            }
        }
        // 对最后一个数累计 等比数列求和 1 + 2 + ... + n = n * (n + 1 ) / 2
        if (freq[40000] > 1) {
            int n = freq[40000] - 1;
            cnt += n * (n + 1) / 2;
        }
        return cnt;
    }
}
